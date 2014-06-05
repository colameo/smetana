package h;
import core.*;
import core.annotation.*;

// 926gualwyh744kklf86qw5qsj

@TranslatedBy("plantuml")
public class _dt_s extends Structure {
	public Dtsearch_f	searchf;/* search function			*/
	public Dtdisc_t	disc;	/* method to manipulate objs		*/
	public Dtdata_t	data;	/* sharable data			*/
	public Dtmemory_f	memoryf;/* function to alloc/free memory	*/
	public Dtmethod_t	meth;	/* dictionary method			*/
	public int		type;	/* type information			*/
	public int		nview;	/* number of parent view dictionaries	*/
	public Dict_t		view;	/* next on viewpath			*/
	public Dict_t		walk;	/* dictionary being walked		*/
	public StarVoid		user;	/* for user's usage			*/
}

// struct _dt_s
// {	Dtsearch_f	searchf;/* search function			*/
// 	Dtdisc_t*	disc;	/* method to manipulate objs		*/
// 	Dtdata_t*	data;	/* sharable data			*/
// 	Dtmemory_f	memoryf;/* function to alloc/free memory	*/
// 	Dtmethod_t*	meth;	/* dictionary method			*/
// 	int		type;	/* type information			*/
// 	int		nview;	/* number of parent view dictionaries	*/
// 	Dt_t*		view;	/* next on viewpath			*/
// 	Dt_t*		walk;	/* dictionary being walked		*/
// 	void*		user;	/* for user's usage			*/
// };