package h;
import core.*;
import core.annotation.*;

// 2bvk4wwyb3pp3ygpa39hp9xqw

@TranslatedBy("plantuml") 
public class agxbuf extends Structure {
	public @Unsigned StarChar buf;	/* start of buffer */
	public @Unsigned StarChar ptr;	/* next place to write */
	public @Unsigned StarChar eptr;	/* end of buffer */
	public boolean dyna;		/* true if buffer is malloc'ed */
}

// typedef struct {
// 	unsigned char *buf;	/* start of buffer */
// 	unsigned char *ptr;	/* next place to write */
// 	unsigned char *eptr;	/* end of buffer */
// 	int dyna;		/* true if buffer is malloc'ed */
//     } agxbuf;