package xxl.search;

import xxl.Range;
import xxl.content.Content;
import xxl.content.ContentBuilder;
import xxl.content.IntegerLiteral;
import xxl.storage.Storage;
import xxl.visitor.ReadContent;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

public class SearchValue implements SearchPredicate {
    @Override
    public boolean test(String argument, Content sheetCellContent, Storage data) {
        IntegerLiteral arg = new IntegerLiteral(argument);
        ReadContent visitor2 = new ReadContent();
        sheetCellContent.requestContent(visitor2, data);
        if (visitor2.readContent().isIntegerLiteral())
            return arg.getValue() == visitor2.readContent().getValue();
        return false;
    }

    @Override
    public Map<Integer, Content> sort(Map<Integer, Content> matchedContent) {
        return matchedContent;  // Don't need to sort anything
    }


}
