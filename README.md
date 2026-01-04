# 🔁 Restart – Android / Flutter App Restart

Questo repository implementa un **meccanismo di riavvio dell’app Android** tramite **codice Java nativo**, integrabile in un progetto **Flutter**.

Il progetto espone funzionalità native Android per forzare il **restart completo dell’applicazione**, utile in casi come:
- reset totale dello stato
- applicazione di configurazioni critiche
- logout “hard”
- recovery dopo errori gravi

---

## ❓ Perché esiste questo progetto

Questo progetto è stato creato perché **non esistevano package Flutter affidabili su pub.dev**
che permettessero di **riavviare completamente un’app Android** in modo semplice e controllato.

I package esistenti:
- erano **abbandonati**
- funzionavano solo parzialmente
- non garantivano un vero *cold restart*
- introducevano dipendenze inutili o comportamenti non chiari

Per questo motivo la logica è stata implementata **direttamente in Java nativo**, esponendo
un’interfaccia minimale verso Flutter tramite `MethodChannel`.

L’obiettivo è:
- avere **controllo totale** sul comportamento
- evitare workaround instabili
- non dipendere da librerie di terze parti

---

## 🧠 Come funziona (in breve)

Il riavvio dell’app viene gestito **lato Android (Java)** tramite:
- `Activity`
- `Intent`
- `PackageManager`
- terminazione del processo corrente

Dal lato Flutter, la funzionalità può essere invocata tramite **MethodChannel**.

---

## 📁 Struttura rilevante

```text
android/app/src/main/java/it/jacko/restart/
├── MainActivity.java        # Entry point Android
├── RestartModule.java       # Logica di restart dell’app
```

## ▶️ Come riavviare l’app

Il riavvio dell’app **non è automatico**: viene eseguito **premendo un pulsante nell’interfaccia Flutter**.

### 📱 Azione utente

👉 **Premere il pulsante “Restart” (o equivalente)** presente nell’app.

Quando il pulsante viene premuto:

1. Flutter invia una chiamata tramite `MethodChannel`
2. Il codice Java Android intercetta la chiamata
3. L’app viene **chiusa e riavviata completamente**
