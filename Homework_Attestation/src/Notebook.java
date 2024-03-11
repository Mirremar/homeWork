import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Notebook {
    String manufacturer;
    Integer ram;
    String os;
    String color;
    Integer hd;

    @Override
    public String toString() {
        return "manufacturer: " + manufacturer + ", ram: " + ram + " GB, os: " + os + ", color: " + color + ", hd: " + hd;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {return true;}
            if (!(obj instanceof Notebook))
            {
                return false;
            }
            Notebook nbk = (Notebook) obj;
            return manufacturer.equals(nbk.manufacturer) && (ram == nbk.ram) && (os.equals(nbk.os)) && (hd == nbk.hd) && (color.equals(nbk.color)) ;

    }

    static ArrayList<Notebook> notebooks = new ArrayList<>();
    static  Map<Integer,String> fieldCorrelation = new HashMap<>();
    static List<Notebook> filteredNotebooks = new ArrayList<>();

    static void noteAdd()
    {
        Notebook n = new Notebook();
        Scanner sc = new Scanner(System.in);
        System.out.println("Введите марку производителя");
        n.manufacturer = sc.next().toUpperCase();
        System.out.println("Введите объём оперативной памяти");
        n.ram = Integer.parseInt(sc.next());
        System.out.println("Введите ОС");
        n.os = sc.next().toLowerCase();
        System.out.println("Введите цвет");
        n.color = sc.next().toLowerCase();
        System.out.println("Введите объём жёсткого диска");
        n.hd = Integer.parseInt(sc.next());
        notebooks.add(n);
    }

    static void noteSearch(HashMap<Integer,String> filterAndExpr)
    {

        if (filterAndExpr.containsKey(1))
        {
            filterByManufacturer(filterAndExpr.get(1));
        }

        if (filterAndExpr.containsKey(2))
        {
            filterByRam(filterAndExpr.get(2));
        }

        if (filterAndExpr.containsKey(3))
        {
            filterByOs(filterAndExpr.get(3));
        }

        if (filterAndExpr.containsKey(4))
        {
            filterByHd(filterAndExpr.get(4));
        }

        if (filterAndExpr.containsKey(5))
        {
            filterByColor(filterAndExpr.get(5));
        }
    }
    static List<Notebook> filterByManufacturer (String f)

    {
            filteredNotebooks = filteredNotebooks.stream()
                    .filter(notebook -> (notebook.manufacturer.equals(f.toUpperCase()))).collect(Collectors.toList());
            return filteredNotebooks;
    }
    static List<Notebook> filterByRam (String f)
    {
        filteredNotebooks = filteredNotebooks.stream()
                .filter(notebook -> (notebook.ram.toString().equals(f))).collect(Collectors.toList());
        return filteredNotebooks;
    }

    static List<Notebook> filterByOs (String f)
    {
        filteredNotebooks = filteredNotebooks.stream()
                .filter(notebook -> (notebook.os.equals(f.toLowerCase()))).collect(Collectors.toList());
        return filteredNotebooks;
    }

    static List<Notebook> filterByHd (String f)
    {
        filteredNotebooks = filteredNotebooks.stream()
                .filter(notebook -> (notebook.hd.toString().equals(f))).collect(Collectors.toList());
        return filteredNotebooks;
    }

    static List<Notebook> filterByColor (String f)
    {
        filteredNotebooks = filteredNotebooks.stream()
                .filter(notebook -> (notebook.color.equals(f.toLowerCase()))).collect(Collectors.toList());
        return filteredNotebooks;
    }
    
    static void initialize()
    {
        Notebook n1 = new Notebook();
        Notebook n2 = new Notebook();
        Notebook n3 = new Notebook();
        Notebook n4 = new Notebook();
        Notebook n5 = new Notebook();
        Notebook n6 = new Notebook();


        n1.manufacturer = "ASUS";
        n1.color = "чёрный";
        n1.ram = 32;
        n1.os = "windows";
        n1.hd = 500;

        n2.manufacturer = "DELL";
        n2.color = "чёрный";
        n2.ram = 64;
        n2.os = "linux";
        n2.hd = 600;

        n3.manufacturer = "HP";
        n3.color = "серый";
        n3.ram = 16;
        n3.os = "windows";
        n3.hd = 700;

        n4.manufacturer = "SAMSUNG";
        n4.color = "белый";
        n4.ram = 32;
        n4.os = "linux";
        n4.hd = 800;

        n5.manufacturer = "ACER";
        n5.color = "красный";
        n5.ram = 8;
        n5.os = "windows";
        n5.hd = 300;

        n6.manufacturer = "APPLE";
        n6.color = "белый";
        n6.ram = 32;
        n6.os = "macos";
        n6.hd = 400;

        notebooks.add(n1);
        notebooks.add(n2);
        notebooks.add(n3);
        notebooks.add(n4);
        notebooks.add(n5);
        notebooks.add(n6);


        fieldCorrelation.put(1,"manufacturer");
        fieldCorrelation.put(2,"ram");
        fieldCorrelation.put(3,"os");
        fieldCorrelation.put(4,"hd");
        fieldCorrelation.put(5,"color");

        filteredNotebooks.addAll(notebooks);
    }

    static HashMap<Integer,String> criteriaReader()
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Введите номера критериев поиска через пробел\n" +
                "Доступные критерии:\n"+
                "1 = Производитель\n"+
                "2 = Оперативная память\n"+
                "3 = Операционная система\n"+
                "4 = Объём жёсткого диска\n"+
                "5 = Цвет");

        String criteria = sc.nextLine();
        //String expression = "";
        String[] filterSplitted = criteria.split(" ");
        ArrayList<Integer> ks = new ArrayList<>();
        HashMap<Integer,String> crit = new HashMap<>();
        for (String item : filterSplitted)
        {
            ks.add(Integer.parseInt(item));
        }
        for (Integer k : ks)
        {
            System.out.println("Введите критерий " + k + "(" + fieldCorrelation.get(k) +")");
            String temp = sc.next();
            //parse?
            crit.put(k,temp);

        }
        return crit;

    }


    //String expressionBuilder()

}
