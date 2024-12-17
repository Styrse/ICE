package ice.ice;

public enum carBrand {
    BMW((long)0.324);
    final long kmPrLitre;

    carBrand(long kmPrLitre) {
        this.kmPrLitre = kmPrLitre;
    }
}
