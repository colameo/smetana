package h;
import core.*;
import core.annotation.*;

// 88aohxn7kudu5j4oxbyvcxvz9

@TranslatedBy("plantuml") 
public class Agdisc_s extends Structure {		/* user's discipline */
    public Agmemdisc_t mem;
    public Agiddisc_t id;
    public Agiodisc_t io;
    
    public void reset() {
        mem = null;
        id = null;
        io = null;
    }
}

// struct Agdisc_s {		/* user's discipline */
//     Agmemdisc_t *mem;
//     Agiddisc_t *id;
//     Agiodisc_t *io;
// };