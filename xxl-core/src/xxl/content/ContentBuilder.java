package xxl.content;

import xxl.exceptions.InvalidFunctionException;

public class ContentBuilder {
    private final String STRING_REGEX = "^'.*";
    private final String INTEGER_REGEX = "^-?\\d+$";
    private final String REFERENCE_REGEX = "^=[1-9]+;[1-9]+$";
    private final String FUNCTION_REGEX = "^=[A-Z]+\\(.+\\)";


    public Content build(String contentSpecification) throws InvalidFunctionException {
        if (contentSpecification.matches(STRING_REGEX))
            return new StringLiteral(contentSpecification);
        if (contentSpecification.matches(INTEGER_REGEX))
            return new IntegerLiteral(contentSpecification);
        if (contentSpecification.matches(REFERENCE_REGEX))
            return new ReferencedContent(contentSpecification);
        if (contentSpecification.matches(FUNCTION_REGEX)) {
            FunctionContent content = new FunctionContent(contentSpecification);
            if (content.isInvalidFunction())
                throw new InvalidFunctionException(content.getFunctionName());
            return content;
        }
        return null;
    }

    public String getStringPattern() { return STRING_REGEX; }
    public String getIntegerPattern() { return INTEGER_REGEX; }
    public String getReferencePattern() { return REFERENCE_REGEX; }
    public String getFunctionPattern() { return FUNCTION_REGEX; }

}
