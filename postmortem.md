# Krypteringsprogram

Filip TE19 2022

## Inledning

Här beskriver du kortfattat arbetets syfte/mål, arbetssätt, genomförande.

Målet var ett krypteringsprogram som tar text som användaren skriver i ett GUI och en nyckel och krypterar texten när den sparas. När en krypterad fil laddas 
med krypteringsprogrammet behövs också en nyckel. All text hanteras som binary så att filstorlekarna blir små.

Mitt arbetssätt var att först göra en fungerande modell som kunde köras genom kontrollern. När modellen fungerade så kunde jag lägga till viewen som då 
bara kommunicerade med kontrollern. Då blev modellen och viewen helt oberoende av varandra. Viewen kopierade jag från mitt notepad projekt för att det hade redan ett 
fungerande layout och filhantering, så då blev det lätt att redigera det för krypteringsmodellen.

## Bakgrund

Modellens enkryptering tar en string och enkrypterar alla characters och gör dem till 4 bytes som sedan förkortas ytterligare till 2 bytes och som skickar vidare en byte array. 

Modellens save metod tar en byte array och ett filnamn och sparar alla bytes till en fil.

Modellens load metod tar ett filnamn och läser alla bytes i en fil och gör det till en byte array.

Modellens dekryptering tar en byte array och en nyckel och dekrypterar varje character med varje character i nyckeln och lägger ihop allt till en string.

Om nyckeln av någon anledning inte är lika lång som meddelandet så loopar nyckeln så att de blir lika långa.

Kontrollern har en samling action listeners som lyssnar efter att användaren trycker på någon av menyknapparna. Kontrollern frågar viewen om 
getkey, getfilename och gettextarea1 när action listeners blir aktiverade och använder sig av modellen så att de blir ihopkopplade.

View har en filechooserdialog för att välja fil att spara eller ladda och en inputdialog för att skriva in nyckeln, det finns också en textarea som man kan skriva text i.

## Positiva erfarenheter

Här beskriver du vad som har gått bra i ditt projekt och analyserar varför. Hur ska du upprepa framgångarna.

Att återanvända view från notepad projektet var lätt och gick fort så att jag kunde lägga tid på andra saker. Mindre justeringar kunde jag göra om det behövdes men jag 
orkar inte hålla på med design mer än nödvändigt.

Det var lätt att hålla modellen och viewen separata när jag gjorde modellen och kontrollern först och sedan viewen. 

Filhanteringen har jag redan exempelkod för så att jag kan bara copy-pastea det för att ladda och spara till filer, så jag tror att det kommer bli lättare att jobba med det i 
framtiden.

## Negativa erfarenheter

Här beskriver du det som du anser har gått mindre bra med ditt projekt och analyserar hur du kan undvika detta i framtida projekt.

## Sammanfattning

Här redovisar du dina slutsatser, erfarenheter och lärdomar. Reflektera över din produkt och dess/dina utvecklingsmöjligheter.
Vad kan vidareutvecklas och finns det utrymme att bygga vidare på projektet.
