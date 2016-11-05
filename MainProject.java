import java.util.Scanner;

public class MainProject {

    public static void main(String[] args) {
        
            try (Scanner scanner = new Scanner(System.in))
            {
                Punto point = new Punto(3.5,3.1);
                System.out.println("Dove vuoi muovere il punto? (N, S, E, O)");
                String input = scanner.next();
                Character input_char = input.charAt(0);
                input_char = Character.toLowerCase(input_char);
                switch(input_char)
                {
                    case 'n':
                        System.out.println(point.GetCoord());
                        point.Nord(1.5);
                        break;
                    case 's':
                        System.out.println(point.GetCoord());
                        point.Sud(1.5);
                        break;
                    case 'e':
                        System.out.println(point.GetCoord());
                        point.Est(1.5);
                        break;
                    case 'o':
                        System.out.println(point.GetCoord());
                        point.Ovest(1.5);
                        break;
                    case 'x':
                        Exit program = new Exit();
                        program.exitProgram();
                        break;
                    default:
                        System.out.println("Non e' una scelta valida. Riprovare.");
                        break;
                }
            
            }
            catch(Exception e)
            {
                System.out.println("ERROR! " + e.getMessage());
            }
    }

}

class Exit {

    private String check_phrase;
    
    public Exit()
    {
        this.check_phrase = "Sei sicuro di voler uscire? (y/n)";
    }
    
    public Exit(String check_phrase)
    {
        this.check_phrase = check_phrase;
    }
    
    public void exitProgram()
    {
        System.out.println("Salvare i punti e le loro posizioni?");
        try (Scanner scanner = new Scanner(System.in))
        {
            boolean right_data = false;
            
            String discard;
            Character discard_c;
            
            do{
            
            discard = scanner.next();
            discard_c = discard.charAt(0);
            discard_c = Character.toLowerCase(discard_c);
            right_data = (discard_c == 'n' || discard_c == 'y') ? true : false;
                
            }while(right_data = false);
            
            if(discard_c == 'y')
            {
                this.saveChanges();
            }
            else
            {
                this.discardChanges();
            }
            
        }
        catch(Exception e)
        {
            System.out.println("ERROR! " + e.getMessage());
        }
    }
    
    public void discardChanges()
    {
        System.exit(0);
    }
    
    public void saveChanges()
    {
        System.exit(0);
    }
    
}

class Punto {
        
    private double x, y;
        
    public Punto(double x, double y) {
        this.x = x;
        this.y = y;
    }
    
    public Punto() {
        this.x = 0;
        this.y = 0;
    }
    public void Nord(double howMuch) {
        this.y += howMuch;
        System.out.println("Il punto si e' mosso di " + howMuch + " unita' a Nord.");
        System.out.println("Ora e' a: " + this.y);
    }
    public void Sud(double howMuch) {
        this.y -= howMuch;
        System.out.println("Il punto si e' mosso di " + howMuch + " unita' a Sud.");
        System.out.println("Ora e' a: " + this.y);
    }
    public void Est(double howMuch) {
        this.x += howMuch;
        System.out.println("Il punto si e' mosso di " + howMuch + " unita' a Est.");
        System.out.println("Ora e' a: " + this.x);
    }
    public void Ovest(double howMuch) {
        this.y -= howMuch;
        System.out.println("Il punto si e' mosso di " + howMuch + " unita' a Ovest.");
        System.out.println("Ora e' a: " + this.x);
    }
    
    public double GetX(){ return x; }
    
    public void SetX(double x){ this.x = x; }
    
    public double GetY(){ return x; }
    
    public void SetY(double x){ this.x = x; }
    
    public String GetCoord(){ return "Il punto e' a coordinate: (" + this.x + ";" + this.y + ")"; }
    public void SetCoord(double x, double y){ this.x = x; this.y = y; }
    
}