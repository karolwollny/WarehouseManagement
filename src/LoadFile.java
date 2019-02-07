
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class LoadFile {
    public File file;
    public int loadFile(String login, String password) throws FileNotFoundException {
        String checkLogin=login;
        String checkPassword=password;
        file = new File("data.txt");
        Scanner in = new Scanner(file);
        while(in.hasNext())
        {
            if(in.next().equals(checkLogin) && in.next().equals(checkPassword))
            {
                int permission=Integer.parseInt(in.next());
                return permission;

            }else{in.nextLine(); }

        }  if(!in.hasNext()){System.out.println("Brak podanego użytkownika w bazie");}

    return 0;
    }


}
