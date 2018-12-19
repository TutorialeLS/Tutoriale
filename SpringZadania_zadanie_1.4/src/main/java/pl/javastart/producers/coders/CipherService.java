package pl.javastart.producers.coders;

public interface CipherService {
    String encrypt(String text);
    String decrypt(String cipher);
}
