import cucumber.api.TypeRegistry;
import cucumber.api.TypeRegistryConfigurer;
import io.cucumber.cucumberexpressions.ParameterType;

import java.util.Locale;


public class TypeRegistryConfiguration implements TypeRegistryConfigurer {


    @Override
    public Locale locale() {
        return null;
    }

    @Override
    public void configureTypeRegistry(TypeRegistry typeRegistry) {
        typeRegistry.defineParameterType(new ParameterType<>(
                "digitalString",
                "\\d*",
                Integer.class,
                (String s) -> Integer.parseInt(s)));

    }
}
