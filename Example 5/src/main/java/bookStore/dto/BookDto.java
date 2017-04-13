package bookStore.dto;

import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

/**
 * Created by Catalysts on 8/9/2015.
 */
public class BookDto {
    @Size(min = 1)
    public String name;
    public int authorId;
    @Pattern(regexp = "^[1-9]+$")
    @Size(min = 5, max = 5, message = "ISBN is the wrong size")
    public String isbn;
}
