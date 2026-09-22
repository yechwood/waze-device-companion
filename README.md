# Waze Device Companion

A small Android app for a Waze-only/kiosk device.

- Handles tel: ACTION_DIAL intents and displays the phone number.
- Does not place calls.
- Handles http/https VIEW intents and displays "Waze devices don't have browsing."
- Has no launcher activity/icon.
- Includes a minimal InCallService declaration for Android dialer-role compatibility.

Build locally with Android Studio or through the included GitHub Actions workflow.
