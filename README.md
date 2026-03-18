# Conversión base a Kotlin + Jetpack Compose

Tomé tu proyecto React/TypeScript y lo aterricé a una base de Android Studio con Kotlin.

## Qué ya quedó mapeado
- `Login.tsx` -> `LoginScreen.kt`
- `ApplicantPortal.tsx` -> `ApplicantPortalScreen.kt`
- `ReservationManagement.tsx` / flujo admin -> `AdminDashboardScreen.kt`
- `NewRequest.tsx` -> `NewRequestScreen.kt`
- `routes.tsx` -> `Destination.kt` + `NavHost`
- `AuthContext.tsx` -> `AuthViewModel.kt`
- `api.ts` mock -> `FakeRepository.kt`

## Qué quedó como placeholder
- Forgot password
- Dashboard general
- Registro de usuario detallado
- Auditoría
- Perfil extendido
- Settings y soporte

## Cómo abrirlo
1. Abre Android Studio.
2. `File > Open` y selecciona esta carpeta.
3. Espera la sincronización de Gradle.
4. Ejecuta en un emulador con Android 8+.

## Nota importante
Esto no es una conversión mágica 1:1 del JSX. Es una migración estructural seria a Compose, que es justo como conviene hacerlo en Android. Tratar de traducir Tailwind, React Router y localStorage literal sería una herejía técnica.
