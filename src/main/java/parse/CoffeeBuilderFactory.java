package parse;

/**
 * Created by User on 21.02.2017.
 */
public class CoffeeBuilderFactory {

    private enum TypeParser{
        SAX ,STAX , DOM
    }

    public AbstractCoffeeParser createCoffeeBuilder(String typeParser){
        TypeParser type = TypeParser.valueOf(typeParser.toUpperCase());
        switch (type){
            case DOM:
                return new DomCoffeeParser();
            case STAX:
                return new StaxCoffeParser();
            case SAX:
                return new SaxCoffeeParser();
            default:
                throw new EnumConstantNotPresentException(type.getDeclaringClass() , type.name());
        }
    }
}
