import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

//Yönergeler: kod çalıştığında istenen bilgileri ekrana yazdıracaktır, ekstra bir şey yapmanız gerekmez.
//alice_in_wonderland.txt belgesinin, dosyanın içinde olup olmadığını kontol etmeniz yeterlidir.
public class Main {
    public static void main(String[] args) {
        //Aranacak kelimelerden bir dizi oluşturdum.
        String[] kelimeler = {"Upon", "Sigh", "Dormouse", "Jury-box", "Swim"};
        HashMap<String, Integer> kelimeSayisi = new HashMap<>();

        //try-catch ile alice_in_wonderland.txt belgesini kontol ediyoruz eğer yoksa hata meajı veriyoruz.
        //belge varsa try devreye giriyor ve kod çalışmaya başlıyor.
        //.toLowerCase() fonksiyonunu kullanarak küçük büyük harf ayrımı gözetmeksizin kelimeleri arıyor ve sayıyorum.
        //sonra da sırayla ekrana yazdırıyorum.
        try (BufferedReader br = new BufferedReader(new FileReader("alice_in_wonderland.txt"))) {
            String satir;
            while ((satir = br.readLine()) != null) {
                satir = satir.toLowerCase();
                for (String kelime : kelimeler) {
                    int sayac = KelimeSayaci(satir, kelime.toLowerCase());
                    if (sayac > 0) {
                        if (kelimeSayisi.containsKey(kelime)) {
                            kelimeSayisi.put(kelime, kelimeSayisi.get(kelime) + sayac);
                        } else {
                            kelimeSayisi.put(kelime, sayac);
                        }
                    }
                }
            }

            for (String kelime : kelimeler) {
                System.out.println(kelime + " kelimesi metinde " + kelimeSayisi.getOrDefault(kelime, 0) + " defa geçmektedir.");
            }

        }
        catch (IOException e) {
            System.err.format("IOException: %s%n", e);
            System.out.println("Lütfen alice_in_wonderland.txt belgesinin konumunu kontrol edin");
        }
    }

    private static int KelimeSayaci(String metin, String desen) {
        //Bu fonksiyonda sayma işlemi gerçekleşiyor
        int sayac = 0;
        int desenUzunlugu = desen.length();
        int metinUzunlugu = metin.length();
        int[] skipTable = SkipTable(desen);

        for (int i = desenUzunlugu - 1; i < metinUzunlugu;) {
            int j = desenUzunlugu - 1;
            while (j >= 0 && i >= 0 && metin.charAt(i) == desen.charAt(j)) {
                if (j == 0) {
                    sayac++;
                    break;
                }
                i--;
                j--;
            }
            i += Math.max(desenUzunlugu - j, skipTable[metin.charAt(i)]);
            if (i >= metinUzunlugu) {
                break;
            }
        }
        return sayac;
    }

    private static int[] SkipTable(String desen) {
        //Boyer-Moore algoritması için gerekli olan "skip table" oluşturuyorum.
        //Dizin uzunluğu 305 diye geçiyor, kapsaması için 306 olarak tanımladım.
        int[] skipTable = new int[306];
        int desenUzunlugu = desen.length();
        int son = desenUzunlugu - 1;
        for (int i = 0; i < skipTable.length; i++) {
            skipTable[i] = desenUzunlugu;
        }
        for (int i = 0; i < son; i++) {
            skipTable[desen.charAt(i)] = son - i;
        }
        return skipTable;
    }
}