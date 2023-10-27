package xxl.content;


import xxl.storage.Storage;
import xxl.visitor.ContentVisitor;

import java.io.Serializable;

public class StringLiteral extends Literal<String> implements Serializable {
    private String _value;

    public StringLiteral(String content) {
        _value = content.substring(1);
    }

    @Override
    public void requestContent(ContentVisitor visitor, Storage data) {visitor.visitString(this);}

    @Override
    public String getValue() {
        return _value;
    }

    @Override
    public String toString() {
        return "'" + _value;
    }

<<<<<<< Updated upstream
<<<<<<< Updated upstream
    public boolean isIntegerLiteral() { return false; }
    public boolean isStringLiteral() { return true; }
    public boolean isFunctionContent() { return false; }
    public boolean isReferencedContent() { return false; }
=======
=======
>>>>>>> Stashed changes
    @Override
    public boolean isStringLiteral() {
        return true;
    }
<<<<<<< Updated upstream
>>>>>>> Stashed changes
=======
>>>>>>> Stashed changes
}
