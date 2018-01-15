package ile_interdite.Controler;

public class ObjetIdentifie {
    private static Integer lastId = 1 ;
    protected Integer id ;
    
    public ObjetIdentifie() {
       this.id = ObjetIdentifie.getNextId();
    } 

    public Integer getId() {
        return this.id ;
    }

    public static Integer getNextId() {
        return lastId++ ;
    }

    public void setId(Integer id) {
        this.id = id ;
    }
    
    
}