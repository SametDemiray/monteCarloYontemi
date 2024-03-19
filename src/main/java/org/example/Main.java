package org.example;
/*

Monte Carlo yöntemi, rasgele sayı üretiminin ve olasılık teorisinin kullanıldığı bir simülasyon yöntemidir. Bu yöntem, belirli bir
problemin analitik olarak çözülememesi veya çözümünün çok zor olması durumunda kullanılır. Pi sayısının Monte Carlo yöntemiyle
hesaplanması için, bir kare içine yerleştirilmiş bir daire düşünelim. Rastgele noktalar bu kareye atıldığında, dairenin içine düşme
olasılığı,karenin alanına oranlanır. İşte bu oran, pi sayısının bir yaklaşık değerini verecektir.
Örneğin,
n adet rastgele nokta atıldığında, bu noktalardan dairenin içine düşen sayısını
m olarak alırsak, pi sayısının bir yaklaşık değeri şu şekilde hesaplanabilir: π ≈ 4m/n
Bir örnek nokta sayısı kullanarak programı çalıştıralım. Örneğin, 10000 rastgele nokta atılarak pi sayısını hesaplayalım:
Rastgele nokta sayısını girin: 10000
Monte Carlo yöntemiyle hesaplanan pi ≈ 3.1444
Bu çıktı, 10000 rastgele nokta atıldığında, Monte Carlo yöntemiyle hesaplanan pi sayısının yaklaşık değerini gösterir.
*/

import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        int n;
        double pi;

        Scanner scanner = new Scanner(System.in);

        // Kullanıcıdan rastgele nokta sayısını alıyoruz.
        System.out.print("Rastgele nokta sayısını girin: ");
        n = scanner.nextInt();

        // Pi sayısının Monte Carlo yöntemiyle hesaplanması
        pi = calculatePi(n);

        // Hesaplanan pi değerini ekrana yazdırıyoruz
        System.out.println("Monte Carlo yöntemiyle hesaplanan pi ≈ " + pi);

        scanner.close();
    }

    // Pi sayısını Monte Carlo yöntemiyle hesaplayan fonksiyon
    public static double calculatePi(int n) {
        int m,i;

        m = 0; // Daire içine düşen noktaların sayısı
        Random random = new Random();

        // Noktaların kare içine atanması ve dairenin içine düşenlerin sayısının hesaplanması
        for (i = 0; i < n; i++) {
            double x = random.nextDouble(); // [0,1) aralığında x koordinatı
            double y = random.nextDouble(); // [0,1) aralığında y koordinatı
            if (x * x + y * y <= 1) {       // Daire içinde mi kontrol et
                m++;
            }
        }

        // Pi sayısının hesaplanması
        return 4.0 * m / n;
    }
}