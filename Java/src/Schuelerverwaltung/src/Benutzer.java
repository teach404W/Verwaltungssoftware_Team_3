

public class Benutzer extends Person{
    private String passwort;
    private String benutzername;
    private boolean angemeldet = false;
    private int counter= 0;
    private Spiel[] spiel = new Spiel[10];
    // Wir erstellen die Spiele für Benutzer damit wir das dem Benutzer zu ordnen
    public void änderePasswort(String pPasswort){
        passwort = pPasswort;
    }

    public Benutzer(String pNutzername, int pAlter, String pPasswort){
        super(pAlter);
        passwort=pPasswort;
        benutzername=pNutzername;

    }
    public void setangemeldet(boolean pangemeldet){
        angemeldet= pangemeldet;
    }
    public boolean getAngemeldet(){
        return angemeldet;
    }
    //Anmelde Funktion relativ simpel eigentlich genau so wie die while schleife in regestriere in menuefuehrung
    public boolean anmeldung(){
    
        
        while (angemeldet ==false) {
            System.out.println("Bitte gib deinen Benutzernamen ein");
            String  pBenutzername = Read.string();
            System.out.println("Bitte gib dein Passwort ein");
            String pPasswort = Read.string();
            System.out.println("Anmeldedaten werden überprüft...");
            //wenn passwort und bejutzername richtig sind vergleich
            if (pPasswort.equals(passwort)) {
                if (pBenutzername.equals(benutzername)){
                    //beides richtig = true
                    angemeldet = true;
                    System.out.println("Anmeldedaten sind richtig sie sind jetzt angemeldet");
                } //wennn eines von beiden falsch ist dann passiert das
                else {
                    System.out.println("Anmeldedaten sind falsch bitte versuche es erneut");
                  
                     angemeldet=false;
                 }
                } else {
               System.out.println("Anmeldedaten sind falsch bitte versuche es erneut");
             
                angemeldet=false;
            }
        }
        return angemeldet;
    }
    //Wir legen auch ein Spiel in Benutzer an
    public Spiel spielanlegen(){
        System.out.println("Bitte gib den Namen des Spiels ein");
        String pName= Read.string();
        System.out.println("Bitte gib das Kaufhahr des Spiels ein");
        int pKaufjahr = Read.number();
        Spiel pSpiel = new Spiel(pName, pKaufjahr);
        return pSpiel;
    }


    public void spielfestlegen(){
        spiel[counter] = spielanlegen();
        System.out.println(spiel[counter].getname());
        counter++;
        
    }
    public void spieleanzeigen(){
        System.out.println("bitte wähle ein spiel aus");
        for (int i = 0; i < counter; i++){
            System.out.println(spiel[i].getname()+ "("+i+")");
        }
    }
    public int menueanzeigen(){
        spieleanzeigen();
        System.out.println("Welches Spiel wählst du?");
        int gamenumber = Read.number();
        System.out.println("Spiel:"+spiel[gamenumber].getname());
      return gamenumber;
    }
    public int spielemenueanzeigen(){
        System.out.println("Wählenn sie aus");
        System.out.println("Errungenschaft anlegen(1)");
        System.out.println("Bewrtung anlegen(2)");
        return Read.number();
    }
    public void spielemenue(){
        int spielnumber= menueanzeigen();
        switch(spielemenueanzeigen()){
            case 1: spiel[spielnumber].errungenschaftanlegen(); break;
            case 2: spiel[spielnumber].bewertungscanner(); break;
        }
    }
    public void spieleUswAusgeben(){
        for (int i = 0; i < counter; i++){
            System.out.println(spiel[i].getname());
            System.out.println("Du hast in diesem Spiel folgende Errungenschaften");
            spiel[i].errungenschaftenausgeben();
         
        }
    }
}

