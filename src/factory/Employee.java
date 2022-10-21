package factory;

public class Employee {
    static String name;
    static double salary;
    static int workHours;
    static int hireYear;
    /*
    Örnek konsol çıktısı:
Adı : kemal
Maaşı : 2000.0
Çalışma Saati : 45
Başlangıç Yılı : 1985
Vergi : 60.0
Bonus : 150.0
Maaş Artışı : 300.0
Vergi ve Bonuslar ile birlikte maaş : 2090.0
Toplam Maaş : 2390.0
     */

        /*
        Notlar

    Toplam maaş: çalışanın kendi maaşı +artış+ bonus
    Vergi ve bonuslarla birlikte maaş için: vergi, bonus ve çalışanın kendi maaşı
    ile bulunacak.
         */

    public static void main(String[] args) {
        Employee calisanBilgileri = new Employee("Kemal", 2000.0, 45, 1985);
        System.out.println(calisanBilgileri);
        System.out.println(Employee.raiseSalary());

    }

    private static double raiseSalary() {
        /*
  raiseSalary() hesaplarken vergi ve bonusları dikkate almalısınız.
 raiseSalary() : Çalışanın işe başlangıç yılına göre maaş artışını hesaplayacaktır.
 Şuan ki yılı 2021 olarak alın.
Eğer çalışan 10 yıldan az bir süredir çalışıyorsa maaşına %5 zam yapılacaktır.
Eğer çalışan 9 yıldan fazla ve 20 yıldan az çalışıyorsa maaşına %10 zam yapılacaktır.
Eğer çalışan 19 yıldan fazla çalışıyorsa %15 zam yapılacaktır.
         */
        int workingYears = 2021 - hireYear;
        double maasArtisi;
        double toplamMaas;
        double vergiBonusHesaplamaliMaas = (salary - tax()) + bonus();

        if (workingYears < 10) {
            maasArtisi = (salary * 5) / 100;
            toplamMaas = vergiBonusHesaplamaliMaas + maasArtisi;
            System.out.println("Maas Artisi : " + maasArtisi);
            System.out.println("Vergi ve Bonuslar ile birlikte : " + vergiBonusHesaplamaliMaas);

        } else if (workingYears < 20) {
            maasArtisi = (salary * 10) / 100;
            toplamMaas = vergiBonusHesaplamaliMaas + maasArtisi;
            System.out.println("Maas Artisi : " + maasArtisi);
            System.out.println("Vergi ve Bonuslar ile birlikte : " + vergiBonusHesaplamaliMaas);
        } else {
            maasArtisi = (salary * 15) / 100;
            toplamMaas = vergiBonusHesaplamaliMaas + maasArtisi;
            System.out.println("Maas Artisi : " + maasArtisi);
            System.out.println("Vergi ve Bonuslar ile birlikte : " + vergiBonusHesaplamaliMaas);
        }
        System.out.print("Toplam Maas :");
        return toplamMaas;
    }

    private static double bonus() {
        /*
        bonus() : Eğer çalışan haftada 40 saatten fazla çalışmış ise fazladan çalıştığı
her saat başına 30 TL olacak şekilde bonus ücretleri hesaplayacaktır.
         */
        double bonus;
        if (workHours > 40) {
            bonus = (workHours - 40) * 30;
            System.out.println("Bonus : " + bonus);
        } else {
            bonus = 0;
            System.out.println("Bonus : " + bonus);
        }
        return bonus;
    }

    private static double tax() {
        /*
        tax() fonksiyonu ile sadece salary'i uygulanan vergi hesaplanacak
        tax() : Maaşa uygulanan vergiyi hesaplayacaktır.
Çalışanın maaşı 1000 TL'den az ise vergi uygulanmayacaktır.
Çalışanın maaşı 1000 TL'den fazla ise maaşının %3'ü kadar vergi uygulanacaktır.
         */
        double tax;
        if (salary > 1000) {
            tax = salary * 3 / 100;
            System.out.println("Vergi : " + tax);
        } else {
            tax = 0;
            System.out.println("Vergi : " + tax);
        }
        return tax;
    }

    public Employee(String name, double salary, int workHours, int hireYear) {
        Employee.name = name;
        Employee.salary = salary;
        Employee.workHours = workHours;
        Employee.hireYear = hireYear;
    }

    @Override
    public String toString() {
        return "Adi : " + name + '\n' + "Maasi : " + salary + '\n' + "Calsima Saati : " + workHours + '\n' + "Baslangic Yili : " + hireYear;
    }
}