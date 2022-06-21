import java.io.*;
import java.text.*;
import java.util.*;

public class StudentList {
    public static void main(String[] args) {

        if (args[0] == null || args.length != 1) {
            System.out.println(Constant.Usage);
            return;
        }
//		Check arguments
        if (args[0].equals(Constant.ShowAll)) {
            System.out.println(Constant.Loading);
            try {
                BufferedReader s = new BufferedReader(new InputStreamReader(new FileInputStream(Constant.StudentList)));
                String r = s.readLine();
                String i[] = r.split(Constant.StudentEntryDeliminetor);
                for (String j : i) {
                    System.out.println(j);
                }
            } catch (Exception e) {

            }
            System.out.println(Constant.load);
        } else if (args[0].equals(Constant.Rew)) {
            System.out.println(Constant.Loading);
            try {
                BufferedReader s = new BufferedReader(new InputStreamReader(new FileInputStream(Constant.StudentList)));
                String r = s.readLine();
                System.out.println(r);
                String i[] = r.split(Constant.StudentEntryDeliminetor);
                Random x = new Random();
                int y = x.nextInt();
                System.out.println(i[y]);
            } catch (Exception e) {
            }
            System.out.println(Constant.load);
        } else if (args[0].contains(Constant.Add)) {
            System.out.println(Constant.Loading);
            try {
                BufferedWriter s = new BufferedWriter(new FileWriter(Constant.StudentList, true));
                String t = args[0].substring(1);
                Date d = new Date();
                String df = Constant.Date;
                DateFormat dateFormat = new SimpleDateFormat(df);
                String fd = dateFormat.format(d);
                s.write(Constant.StudentEntryDeliminetor + t + Constant.Update + fd);
                s.close();
            } catch (Exception e) {
            }

            System.out.println(Constant.load);
        } else if (args[0].contains(Constant.Asking)) {
            System.out.println(Constant.Loading);
            try {
                BufferedReader s = new BufferedReader(new InputStreamReader(new FileInputStream(Constant.StudentList)));
                String r = s.readLine();
                String i[] = r.split(Constant.StudentEntryDeliminetor);
                boolean done = false;
                String t = args[0].substring(1);
                for (int idx = 0; idx < i.length && !done; idx++) {
                    if (i[idx].equals(t)) {
                        System.out.println(Constant.Found);
                        done = true;
                    }
                }
            } catch (Exception e) {
            }
            System.out.println(Constant.load);
        } else if (args[0].contains(Constant.Count)) {
            System.out.println(Constant.Loading);
            try {
                BufferedReader s = new BufferedReader(new InputStreamReader(new FileInputStream(Constant.StudentList)));
                String D = s.readLine();
                char a[] = D.toCharArray();
                boolean in_word = false;
                int count = 0;
                for (char c : a) {
                    if (c == ' ') {
                        if (!in_word) {
                            count++;
                            in_word = true;
                        } else {
                            in_word = false;
                        }
                    }
                }
                System.out.println(count + Constant.Founds + a.length);
            } catch (Exception e) {
            }
            System.out.println(Constant.load);
        } else {
            System.out.println(Constant.Usage);
        }
    }
}