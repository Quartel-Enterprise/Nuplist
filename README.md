## Description

This is a Compose Multiplatform project targeting Android, iOS and Desktop for wedding.

---

## Prerequisites
1) **Google Cloud project**: Go to the [Google Cloud Platform](https://console.cloud.google.com/home/dashboard) and create a new project if necessary.
2) **Supabase project**: Create a project in [supabase](https://supabase.com/).

## Configuration
1) Configure OAuth credentials for your Google Cloud project in the Credentials page of the console. When creating a new OAuth client ID, choose WEB. 
2) Configure the [OAuth Consent Screen](https://console.cloud.google.com/apis/credentials/consent). This information is shown to the user when giving consent to your app. In particular, make sure you have set up links to your app's privacy policy and terms of service.
3) Add the client ID from previous step in the [Google provider on the Supabase Dashboard](https://supabase.com/dashboard/project/_/auth/providers), under Client IDs.
4) Create a file `local.properties` (if it doesn't exist yet) in the root of the project. Add the following:
```
SUPABASE_URL=<your supabase project url>
SUPABASE_API_KEY=<your supabase url key>
WEB_GOOGLE_CLIENT_ID=<your google web client id>
```
