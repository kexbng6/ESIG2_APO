public class Item {
    String question;
    String reponse;
    private int id;


    public Item(String question, String reponse, int id) {
        this.question = question;
        this.reponse = reponse;
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public boolean testerReponse(String reponseUser){

        if(reponseUser.equals(obtenirBonneReponse()))
        {
            return true;
        }
        return false;
    }


    public String obtenirBonneReponse(){

        return "";
    }

    @Override
    public String toString() {
        return "Item{" +
                "question='" + question + '\'' +
                ", reponse='" + reponse + '\'' +
                ", id=" + id +
                '}';
    }
}
