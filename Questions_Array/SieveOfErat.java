public class SieveOfErat {
    
    // //? if prime return true.
    // static boolean isPrime(int n) {

    //     for (int i = 2; i * i < n; i++) {
    //         if (n % i == 0)
    //             return false;
    //     }
    //     return true;
    // }
    
    static void sieveOfErat(int n,boolean[] primes) {
        for (int i = 2; i * i < n; i++) {
            if(primes[i]){
                for(int j=i*2;j*j<n;j+=i){
                    
                }
            }
        }
    }
}