<h1>Lecturer questions and anwers to them</h1>

**Ar buvo aiškus ir patogus unit testai, ar kodas aiškus.**

Patys testai buvo, kadangi buvo apibrėžti labai plačiu namingu, tad buvau tikras, kas tuo testu bandoma patikrinti, dėl patogumo vienintelis niuansas buvo kai kurių testų nekorektiškumas, bet studentas su manim padiskutavo bei radom kompromisą. Tad bendras reziume - dirbti buvo patogu.
  
**Kaip jus galėtumete juos pagerinti**

Turbūt klausimas ne tik turbūt kaip galėčiau pagerint, bet ir pagerinau. Su testų autoriumi padiskutavus pamodifikavau dalį jų, kad jie būtų validūs. Vienas esminių pokyčių buvo išėmimas parametrų iš metodų kaip nelegalių simbolių char masyvo padavimas ar slaptažodžio ilgio perdavimas. (pvz.: `validate("123!Abcd", 6, new char[]{'!', '@', '#'}))`). Taip pat buvo išimtas ir vienas testas iš Email validacijos, kuri tikrino, kad domaino name nebūtų ne ASCII simobliu (pvz.: lietuviškų simbolių), kadangi pagal RFC 6532 (https://datatracker.ietf.org/doc/html/rfc6532) šis testas iš esmės yra paneigiamas.
	
**Kokius unit testus jus galėtumėte pridėti (jei tokių yra)**

Galėčiau daugiau turbūt pridėti testų, kurie patestuotų logika naudojant ne įprastą konstruktorių (t.y. be parametrų), bet konstruktorių, kuriam gali pats perduoti simbolius, kurie yra nevalidūs ir pnš. - tai padėtų patikrinti, kad logika veikia ne tik su standartiniais validacijos parametrais

P.S. Implementuota logika ir paredaguoti testai yra Pull requestuose (prieš atnaujint kolegos testus pas save, pirma buvo iškeltas pull requestas kolegos repozitorijoje ir buvo kolegos paaprove'intas)

<h1>Library</h1>
<div>
1st Laboratory work of Vilnius University student.
</div>
<h2>Business requirements</h2>

<h3>
  PasswordChecker
</h3>
 - Checks if the password is at least X long<br>
- Checks for Uppercase characters<br>
- Checks for a special character (list of special characters must be configured)<br>
<br>
<h3>
  PhoneValidator
</h3>
- There are no other characters than numbers
<br>- If it starts with 8, it changes to +370
<br>- It is possible to add new validation rules by country (length and prefix)
<h3>
  EmailValidator
</h3>
- Has @ symbol<br>
- No invalid characters<br>
- Has the correct domain and TLD

