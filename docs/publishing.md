# Publishing CBCHAIN

## Coordinates

The project uses the verified namespace `com.spinyowl` and artifact ID `cbchain`.
The release version comes from `version` in `gradle.properties` (currently `1.0.3`).
The generated POM includes project, MIT license, developer and SCM metadata.
Main, sources and Javadoc JARs are included.

## Local artifacts and CI

With JDK 17 selected, build and prepare the local Maven repository:

```sh
./gradlew clean build publishAllPublicationsToLocalArtifactsRepository --warning-mode fail
```

Artifacts are written to `build/publish/com/spinyowl/cbchain/<version>/`.
This command needs no Sonatype credentials or signing key and does not upload to Central.
CI runs for pushes and PRs to `develop`, and supports manual checks.
Pushes to `develop` also copy artifacts to `SpinyOwl/repo` on `releases`,
unless the commit message contains `[skip publish]`. The reusable workflow
`.github/workflows/publish-github.yml` builds the artifacts and uses
`SpinyOwl/publish-artifact-to-git@2.0.0` with `GH_PAT` and `no_delete=true`,
preserving existing artifacts for other libraries and versions.

For a manual run, select **CI** in GitHub Actions and choose the source ref.
The two boolean inputs default to `false`:

| `publish_github` | `publish_sonatype` | Manual run |
| --- | --- | --- |
| `false` | `false` | Build only |
| `true` | `false` | Also publish to `SpinyOwl/repo:releases` |
| `false` | `true` | Also build, sign and stage a Central Portal deployment |
| `true` | `true` | Publish to Git and stage in Central Portal |

CI calls `.github/workflows/publish-github.yml` and
`.github/workflows/publish-central.yml` as separate jobs. Each publication workflow
builds the selected ref independently; Git publication receives the `GH_PAT`
secret, and Sonatype receives its publishing and signing secrets.
`[skip publish]` controls automatic push publication; explicit manual selections
control manual publication. PRs never publish to either remote.

## Central Portal credentials and GPG key

1. Generate a publishing user token in [Central Portal](https://central.sonatype.org/publish/generate-portal-token/).
   Use its username and password, rather than your account login credentials.
2. Create or select a GPG signing key and publish its public key as described in
   [Sonatype's GPG documentation](https://central.sonatype.org/publish/requirements/gpg/).
3. Add these GitHub repository Actions secrets:

| Secret | Value |
| --- | --- |
| `MAVEN_CENTRAL_USERNAME` | Central Portal user token username |
| `MAVEN_CENTRAL_PASSWORD` | Central Portal user token password |
| `SIGNING_KEY` | Complete ASCII-armored private GPG key, including header and footer |
| `SIGNING_PASSWORD` | Private key passphrase; omit for an unprotected key |

Keep credentials and private keys out of the repository.

For local commands, supply the equivalent environment variables:

- `ORG_GRADLE_PROJECT_mavenCentralUsername`
- `ORG_GRADLE_PROJECT_mavenCentralPassword`
- `ORG_GRADLE_PROJECT_signingInMemoryKey`
- `ORG_GRADLE_PROJECT_signingInMemoryKeyPassword` (when the key has a passphrase)
- `ORG_GRADLE_PROJECT_signingInMemoryKeyId` (optional, when selecting a signing subkey)

## Verify signed artifacts locally

With the signing variables configured, prepare a signed local repository:

```sh
./gradlew clean build publishAllPublicationsToLocalArtifactsRepository -PcentralPublishing=true --warning-mode fail
```

This signs the POM, Gradle module metadata and all three JARs. It does not upload
to Central and needs no Sonatype token. Verify the `.asc` files with `gpg --verify`.

## Stage and release in Maven Central

1. Set a release version in `gradle.properties`. Maven Central versions are immutable;
   choose a version that has not already been published. This release workflow rejects `-SNAPSHOT`.
2. Run **CI** from GitHub Actions on the intended source ref with `publish_sonatype=true`.
   Set `publish_github=true` as well if the Git artifact repository should be updated.
   The version is read from `gradle.properties`; no separate version input is needed.
3. The workflow builds, signs and uploads a deployment through the Central Portal API.
4. Review validation at [Central Portal deployments](https://central.sonatype.com/publishing/deployments)
   and select **Publish** to make the release available in Maven Central.

The equivalent local upload command is:

```sh
./gradlew clean build publishToMavenCentral -PcentralPublishing=true --warning-mode fail
```

`centralPublishing=true` explicitly enables the Central target and mandatory signing.
When enabled, the aggregate `publish` task also includes Central; use the specific
local repository task for offline preparation. Automatic release is disabled.

After the first Central release, consumers can use `mavenCentral()` and
`implementation("com.spinyowl:cbchain:<published-version>")` without the custom Git repository.

References: [Central requirements](https://central.sonatype.org/publish/requirements/),
[Gradle publishing plugin](https://vanniktech.github.io/gradle-maven-publish-plugin/central/).
