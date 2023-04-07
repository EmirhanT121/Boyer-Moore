# Boyer-Moore
 Boyer-Moore algoritması bir dizi eşleştirme algoritmasıdır, bir metnin içindeki belirli bir modeli aramak için kullanılır. Diğer yaygın olarak kullanılan dize eşleştirme algoritmalarıyla karşılaştırıldığında, bu algoritma daha hızlı çalışabilir.

Boyer-Moore algoritması, bir örüntüyü sağdan sola tarayarak eşleştirme fikrine dayanmaktadır. Algoritma, şablondaki karakterleri sağdan sola eşleştirerek metnin karakterlerini kontrol eder. Bunun haricinde iki önemli kavram olan "önyargı" ve "suffiks" kullanır. Önyargı, desendeki bir karakterin metinde olmadığı zaman, aramanın hangi yönde atlanacağını belirler. Suffiks ise, eşleşmeyen bir karakterin desen içindeki konumunu belirleyerek, aramanın nereden devam edeceğini gösterir.

Uzun lafın kısası; Boyer-Moore algoritması, sağdan sola doğru desen taraması yaparak metindeki karakterleri kontrol eder ve önyargı, suffiks kavramlarını kullanarak arama süresini azaltır. Bu nedenle, özellikle büyük metinlerde ve uzun desenlerde etkili bir şekilde kullanılabilir.


En iyi durumda, Boyer-Moore algoritması sabit zamanlıdır ve desenin uzunluğu ile doğrudan ilişkilidir. En iyi durum, desenin metinde bulunduğu bir durumdur. Bu durumda, algoritmanın çalışma zamanı O(m) olur.

Ortalama durumda, algoritmanın çalışma zamanı daha iyi performans gösterir ve O(n/m)’dir. Bu durumda, desenin uzunluğu, metnin uzunluğunun bir sabiti kadar daha büyük olduğunda en iyi sonuç alınır. Bu durum, desenin metinde rastgele dağıldığı bir durumdur.

En kötü durumda ise, Boyer-Moore algoritması O(mn) çalışma zamanına sahiptir. Burada m desenin uzunluğu ve n metnin uzunluğudur. O(mn) durumu, desenin metindeki her konuma uymadığı ve her karakteri karşılaştırmak için ileri ve geri sıçramanın gerektiği bir durumdur. Bu durum genellikle nadir görülür, ancak durumun algoritmanın performansını etkilemesini önlemek için çeşitli optimizasyon teknikleri kullanılabilir.