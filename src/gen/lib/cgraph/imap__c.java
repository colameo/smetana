/* ========================================================================
 * PlantUML : a free UML diagram generator
 * ========================================================================
 *
 * (C) Copyright 2009-2017, Arnaud Roques
 *
 * Project Info:  http://plantuml.com
 * 
 * This file is part of PlantUML.
 *
 * PlantUML is free software; you can redistribute it and/or modify it
 * under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * PlantUML distributed in the hope that it will be useful, but
 * WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY
 * or FITNESS FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public
 * License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with this library; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston, MA  02110-1301,
 * USA.
 *
 *
 * Original Author:  Arnaud Roques
 *
 *
 *
 *
 *************************************************************************
 * Copyright (c) 2011 AT&T Intellectual Property 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors: See CVS logs. Details at http://www.graphviz.org/
 *************************************************************************
 *
 */
package gen.lib.cgraph;
import h.*;
import smetana.core.*;
import static smetana.core.Macro.*;
import static smetana.core.JUtils.*;
import static gen.lib.cdt.dtclose__c.*;
import static gen.lib.cdt.dtdisc__c.*;
import static gen.lib.cdt.dtextract__c.*;
import static gen.lib.cdt.dtflatten__c.*;
import static gen.lib.cdt.dthash__c.*;
import static gen.lib.cdt.dtlist__c.*;
import static gen.lib.cdt.dtmethod__c.*;
import static gen.lib.cdt.dtopen__c.*;
import static gen.lib.cdt.dtrenew__c.*;
import static gen.lib.cdt.dtrestore__c.*;
import static gen.lib.cdt.dtsize__c.*;
import static gen.lib.cdt.dtstat__c.*;
import static gen.lib.cdt.dtstrhash__c.*;
import static gen.lib.cdt.dttreeset__c.*;
import static gen.lib.cdt.dttree__c.*;
import static gen.lib.cdt.dtview__c.*;
import static gen.lib.cdt.dtwalk__c.*;
import static gen.lib.cgraph.agerror__c.*;
import static gen.lib.cgraph.agxbuf__c.*;
import static gen.lib.cgraph.apply__c.*;
import static gen.lib.cgraph.attr__c.*;
import static gen.lib.cgraph.cmpnd__c.*;
import static gen.lib.cgraph.edge__c.*;
import static gen.lib.cgraph.flatten__c.*;
import static gen.lib.cgraph.grammar__c.*;
import static gen.lib.cgraph.graph__c.*;
import static gen.lib.cgraph.id__c.*;
import static gen.lib.cgraph.imap__c.*;
import static gen.lib.cgraph.io__c.*;
import static gen.lib.cgraph.main__c.*;
import static gen.lib.cgraph.mem__c.*;
import static gen.lib.cgraph.node__c.*;
import static gen.lib.cgraph.obj__c.*;
import static gen.lib.cgraph.pend__c.*;
import static gen.lib.cgraph.rec__c.*;
import static gen.lib.cgraph.refstr__c.*;
import static gen.lib.cgraph.scan__c.*;
import static gen.lib.cgraph.subg__c.*;
import static gen.lib.cgraph.tester__c.*;
import static gen.lib.cgraph.utils__c.*;
import static gen.lib.cgraph.write__c.*;
import static gen.lib.cgraph.y_tab__c.*;
import static gen.lib.circogen.blockpath__c.*;
import static gen.lib.circogen.blocktree__c.*;
import static gen.lib.circogen.block__c.*;
import static gen.lib.circogen.circpos__c.*;
import static gen.lib.circogen.circularinit__c.*;
import static gen.lib.circogen.circular__c.*;
import static gen.lib.circogen.deglist__c.*;
import static gen.lib.circogen.edgelist__c.*;
import static gen.lib.circogen.nodelist__c.*;
import static gen.lib.circogen.nodeset__c.*;
import static gen.lib.common.args__c.*;
import static gen.lib.common.arrows__c.*;
import static gen.lib.common.colxlate__c.*;
import static gen.lib.common.ellipse__c.*;
import static gen.lib.common.emit__c.*;
import static gen.lib.common.geom__c.*;
import static gen.lib.common.globals__c.*;
import static gen.lib.common.htmllex__c.*;
import static gen.lib.common.htmlparse__c.*;
import static gen.lib.common.htmltable__c.*;
import static gen.lib.common.input__c.*;
import static gen.lib.common.intset__c.*;
import static gen.lib.common.labels__c.*;
import static gen.lib.common.memory__c.*;
import static gen.lib.common.ns__c.*;
import static gen.lib.common.output__c.*;
import static gen.lib.common.pointset__c.*;
import static gen.lib.common.postproc__c.*;
import static gen.lib.common.psusershape__c.*;
import static gen.lib.common.routespl__c.*;
import static gen.lib.common.shapes__c.*;
import static gen.lib.common.splines__c.*;
import static gen.lib.common.strcasecmp__c.*;
import static gen.lib.common.strncasecmp__c.*;
import static gen.lib.common.taper__c.*;
import static gen.lib.common.textspan__c.*;
import static gen.lib.common.timing__c.*;
import static gen.lib.common.utils__c.*;
import static gen.lib.common.y_tab__c.*;
import static gen.lib.dotgen.acyclic__c.*;
import static gen.lib.dotgen.aspect__c.*;
import static gen.lib.dotgen.class1__c.*;
import static gen.lib.dotgen.class2__c.*;
import static gen.lib.dotgen.cluster__c.*;
import static gen.lib.dotgen.compound__c.*;
import static gen.lib.dotgen.conc__c.*;
import static gen.lib.dotgen.decomp__c.*;
import static gen.lib.dotgen.dotinit__c.*;
import static gen.lib.dotgen.dotsplines__c.*;
import static gen.lib.dotgen.fastgr__c.*;
import static gen.lib.dotgen.flat__c.*;
import static gen.lib.dotgen.mincross__c.*;
import static gen.lib.dotgen.position__c.*;
import static gen.lib.dotgen.rank__c.*;
import static gen.lib.dotgen.sameport__c.*;
import static gen.lib.dotgen2.decomp__c.*;
import static gen.lib.dotgen2.dotinit__c.*;
import static gen.lib.dotgen2.groups__c.*;
import static gen.lib.dotgen2.level__c.*;
import static gen.lib.dotgen2.minc2__c.*;
import static gen.lib.dotgen2.minc_utils__c.*;
import static gen.lib.dotgen2.ns__c.*;
import static gen.lib.fdpgen.clusteredges__c.*;
import static gen.lib.fdpgen.comp__c.*;
import static gen.lib.fdpgen.dbg__c.*;
import static gen.lib.fdpgen.fdpinit__c.*;
import static gen.lib.fdpgen.grid__c.*;
import static gen.lib.fdpgen.layout__c.*;
import static gen.lib.fdpgen.tlayout__c.*;
import static gen.lib.fdpgen.xlayout__c.*;
import static gen.lib.gvc.gvbuffstderr__c.*;
import static gen.lib.gvc.gvconfig__c.*;
import static gen.lib.gvc.gvcontext__c.*;
import static gen.lib.gvc.gvc__c.*;
import static gen.lib.gvc.gvdevice__c.*;
import static gen.lib.gvc.gvevent__c.*;
import static gen.lib.gvc.gvjobs__c.*;
import static gen.lib.gvc.gvlayout__c.*;
import static gen.lib.gvc.gvloadimage__c.*;
import static gen.lib.gvc.gvplugin__c.*;
import static gen.lib.gvc.gvrender__c.*;
import static gen.lib.gvc.gvtextlayout__c.*;
import static gen.lib.gvc.gvusershape__c.*;
import static gen.lib.gvc.regex_win32__c.*;
import static gen.lib.label.index__c.*;
import static gen.lib.label.node__c.*;
import static gen.lib.label.nrtmain__c.*;
import static gen.lib.label.rectangle__c.*;
import static gen.lib.label.split_q__c.*;
import static gen.lib.label.xlabels__c.*;
import static gen.lib.ortho.fPQ__c.*;
import static gen.lib.ortho.maze__c.*;
import static gen.lib.ortho.ortho__c.*;
import static gen.lib.ortho.partition__c.*;
import static gen.lib.ortho.rawgraph__c.*;
import static gen.lib.ortho.sgraph__c.*;
import static gen.lib.ortho.trapezoid__c.*;
import static gen.lib.pack.ccomps__c.*;
import static gen.lib.pack.pack__c.*;
import static gen.lib.pack.ptest__c.*;
import static gen.lib.pathplan.cvt__c.*;
import static gen.lib.pathplan.inpoly__c.*;
import static gen.lib.pathplan.route__c.*;
import static gen.lib.pathplan.shortestpth__c.*;
import static gen.lib.pathplan.shortest__c.*;
import static gen.lib.pathplan.solvers__c.*;
import static gen.lib.pathplan.triang__c.*;
import static gen.lib.pathplan.util__c.*;
import static gen.lib.pathplan.visibility__c.*;
import static gen.lib.xdot.xdot__c.*;

public class imap__c {
//1 9k44uhd5foylaeoekf3llonjq
// extern Dtmethod_t* 	Dtset


//1 1ahfywsmzcpcig2oxm7pt9ihj
// extern Dtmethod_t* 	Dtbag


//1 anhghfj3k7dmkudy2n7rvt31v
// extern Dtmethod_t* 	Dtoset


//1 5l6oj1ux946zjwvir94ykejbc
// extern Dtmethod_t* 	Dtobag


//1 2wtf222ak6cui8cfjnw6w377z
// extern Dtmethod_t*	Dtlist


//1 d1s1s6ibtcsmst88e3057u9r7
// extern Dtmethod_t*	Dtstack


//1 axa7mflo824p6fspjn1rdk0mt
// extern Dtmethod_t*	Dtqueue


//1 ega812utobm4xx9oa9w9ayij6
// extern Dtmethod_t*	Dtdeque


//1 cyfr996ur43045jv1tjbelzmj
// extern Dtmethod_t*	Dtorder


//1 wlofoiftbjgrrabzb2brkycg
// extern Dtmethod_t*	Dttree


//1 12bds94t7voj7ulwpcvgf6agr
// extern Dtmethod_t*	Dthash


//1 9lqknzty480cy7zsubmabkk8h
// extern Dtmethod_t	_Dttree


//1 bvn6zkbcp8vjdhkccqo1xrkrb
// extern Dtmethod_t	_Dthash


//1 9lidhtd6nsmmv3e7vjv9e10gw
// extern Dtmethod_t	_Dtlist


//1 34ujfamjxo7xn89u90oh2k6f8
// extern Dtmethod_t	_Dtqueue


//1 3jy4aceckzkdv950h89p4wjc8
// extern Dtmethod_t	_Dtstack


//1 8dfqgf3u1v830qzcjqh9o8ha7
// extern Agmemdisc_t AgMemDisc


//1 18k2oh2t6llfsdc5x0wlcnby8
// extern Agiddisc_t AgIdDisc


//1 a4r7hi80gdxtsv4hdoqpyiivn
// extern Agiodisc_t AgIoDisc


//1 bnzt5syjb7mgeru19114vd6xx
// extern Agdisc_t AgDefaultDisc


//1 35y2gbegsdjilegaribes00mg
// extern Agdesc_t Agdirected, Agstrictdirected, Agundirected,     Agstrictundirected


//1 c2rygslq6bcuka3awmvy2b3ow
// typedef Agsubnode_t	Agnoderef_t


//1 xam6yv0dcsx57dtg44igpbzn
// typedef Dtlink_t	Agedgeref_t


//1 6ayavpu39aihwyojkx093pcy3
// extern Agraph_t *Ag_G_global


//1 871mxtg9l6ffpxdl9kniwusf7
// extern char *AgDataRecName


//1 c0o2kmml0tn6hftuwo0u4shwd
// extern Dtdisc_t Ag_subnode_id_disc


//1 8k15pyu256unm2kpd9zf5pf7k
// extern Dtdisc_t Ag_subnode_seq_disc


//1 e3d820y06gpeusn6atgmj8bzd
// extern Dtdisc_t Ag_mainedge_id_disc


//1 cbr0772spix9h1aw7h5v7dv9j
// extern Dtdisc_t Ag_subedge_id_disc


//1 akd0c3v0j7m2npxcb9acit1fa
// extern Dtdisc_t Ag_mainedge_seq_disc


//1 12d8la07351ww7vwfzucjst8m
// extern Dtdisc_t Ag_subedge_seq_disc


//1 29eokk7v88e62g8o6lizmo967
// extern Dtdisc_t Ag_subgraph_id_disc


//1 4xd9cbgy6hk5g6nhjcbpzkx14
// extern Agcbdisc_t AgAttrdisc




//3 79n6elfqk1vw36hmv7bxlrb0v
// static int idcmpf(Dict_t * d, void *arg_p0, void *arg_p1, Dtdisc_t * disc) 
public static Object idcmpf(Object... arg) {
UNSUPPORTED("1r7psgafk53qtogr4ft1z3lze"); // static int idcmpf(Dict_t * d, void *arg_p0, void *arg_p1, Dtdisc_t * disc)
UNSUPPORTED("erg9i1970wdri39osu8hx2a6e"); // {
UNSUPPORTED("4ntp67b3zenb7lwin6la68y9g"); //     IMapEntry_t *p0, *p1;
UNSUPPORTED("6z29omss9ay00bqf6xael7t6t"); //     (void) d;
UNSUPPORTED("44n3fpcv1bzssspskdg8kbbz4"); //     p0 = arg_p0;
UNSUPPORTED("4tgwqnnain0i2lv7it6su8k8q"); //     p1 = arg_p1;
UNSUPPORTED("8l8wg6vltx6d7vc9dzqb6n3wi"); //     (void) disc;
UNSUPPORTED("49gg5v29upcoktnre7tua6o3j"); //     return (p0->id - p1->id);
UNSUPPORTED("c24nfmv9i7o5eoqaymbibp7m7"); // }

throw new UnsupportedOperationException();
}




//3 aadw62b6y0d22xf4720pzdiyz
// static int namecmpf(Dict_t * d, void *arg_p0, void *arg_p1, 		    Dtdisc_t * disc) 
public static Object namecmpf(Object... arg) {
UNSUPPORTED("7ouzah61jyng2a8u8dfdxeekw"); // static int namecmpf(Dict_t * d, void *arg_p0, void *arg_p1,
UNSUPPORTED("3hfqv3wxw19wel6xzpj1kbshb"); // 		    Dtdisc_t * disc)
UNSUPPORTED("erg9i1970wdri39osu8hx2a6e"); // {
UNSUPPORTED("4ntp67b3zenb7lwin6la68y9g"); //     IMapEntry_t *p0, *p1;
UNSUPPORTED("6z29omss9ay00bqf6xael7t6t"); //     (void) d;
UNSUPPORTED("44n3fpcv1bzssspskdg8kbbz4"); //     p0 = arg_p0;
UNSUPPORTED("4tgwqnnain0i2lv7it6su8k8q"); //     p1 = arg_p1;
UNSUPPORTED("8l8wg6vltx6d7vc9dzqb6n3wi"); //     (void) disc;
UNSUPPORTED("eb7z4ayiwked6cpuntm496002"); //     return (p0->str - p1->str);
UNSUPPORTED("c24nfmv9i7o5eoqaymbibp7m7"); // }

throw new UnsupportedOperationException();
}


//1 cvijg1ekkl36sildxxf28vhug
// static Dtdisc_t LookupByName = 


//1 dkzjlpsv4zk993r3iyo7msr8n
// static Dtdisc_t LookupById = 




//3 mx2krtbgfhcihopw9rw8kcv3
// int aginternalmaplookup(Agraph_t * g, int objtype, char *str, 			unsigned long *result) 
public static int aginternalmaplookup(Agraph_s g, int objtype, CString str, int result[]) {
ENTERING("mx2krtbgfhcihopw9rw8kcv3","aginternalmaplookup");
try {
 UNSUPPORTED("9xuzgjxqveawe6v2n4x48r93l"); // int aginternalmaplookup(Agraph_t * g, int objtype, char *str,
UNSUPPORTED("a9jw0mphzrt0q739cxcgk2hxw"); // 			unsigned long *result)
UNSUPPORTED("erg9i1970wdri39osu8hx2a6e"); // {
UNSUPPORTED("l4y6zpshfefue2m18wlswfkp"); //     Dict_t *d;
UNSUPPORTED("6ich6qfkkifpsux1v4vgzhiyb"); //     IMapEntry_t *sym, template;
UNSUPPORTED("4uffdlbjda8w15jyto7gd77bw"); //     char *search_str;
UNSUPPORTED("84sccu12ven74lipf2dljgik4"); //     if (objtype == AGINEDGE)
UNSUPPORTED("5q9qhv35w1rsuiuzqkwgshm3p"); // 	objtype = AGEDGE;
UNSUPPORTED("drm2n6i20x3uimml5ooxm9u25"); //     if ((d = g->clos->lookup_by_name[objtype])) {
UNSUPPORTED("9ysphludc93c139uov8ximaj2"); // 	if ((search_str = agstrbind(g, str))) {
UNSUPPORTED("73apfmwxngxpf2twqiokd75ph"); // 	    template.str = search_str;
UNSUPPORTED("1r11yngj3z66q9h8k7rx0ifra"); // 	    sym = (IMapEntry_t *) (*(((Dt_t*)(d))->searchf))((d),(void*)(&template),0000004);
UNSUPPORTED("8watgmdse1o9uhfuhoexemnl2"); // 	    if (sym) {
UNSUPPORTED("68xn6zrkilfqqsosou3z2ym7o"); // 		*result = sym->id;
UNSUPPORTED("a1a1uhff21noh1htwzn6yp831"); // 		return (!(0));
UNSUPPORTED("6t98dcecgbvbvtpycwiq2ynnj"); // 	    }
UNSUPPORTED("flupwh3kosf3fkhkxllllt1"); // 	}
UNSUPPORTED("dvgyxsnyeqqnyzq696k3vskib"); //     }
UNSUPPORTED("297p5iu8oro94tdg9v29bbgiw"); //     return (0);
UNSUPPORTED("c24nfmv9i7o5eoqaymbibp7m7"); // }

throw new UnsupportedOperationException();
} finally {
LEAVING("mx2krtbgfhcihopw9rw8kcv3","aginternalmaplookup");
}
}




//3 ce8fo5gya95enhgssezqs3vav
// void aginternalmapinsert(Agraph_t * g, int objtype, char *str, 			 unsigned long id) 
public static Object aginternalmapinsert(Object... arg) {
UNSUPPORTED("bk4ucrzua03gr9lak6zfm3orp"); // void aginternalmapinsert(Agraph_t * g, int objtype, char *str,
UNSUPPORTED("18mfx819yhg1vg5xkrfjr96x2"); // 			 unsigned long id)
UNSUPPORTED("erg9i1970wdri39osu8hx2a6e"); // {
UNSUPPORTED("bh4b0zdn246m225u6zmdk75zs"); //     IMapEntry_t *ent;
UNSUPPORTED("84hwqfygghmcbo2exzo01t93o"); //     Dict_t *d_name_to_id, *d_id_to_name;
UNSUPPORTED("7wtz0h3ahdkrul4dbb0b7y0l4"); //     ent = ((IMapEntry_t*)(agalloc(g,sizeof(IMapEntry_t))));
UNSUPPORTED("6nwwse4s1ba0m9jfptthwwjbj"); //     ent->id = id;
UNSUPPORTED("d8vvc9mhtu43xfmzodcja9bu9"); //     ent->str = agstrdup(g, str);
UNSUPPORTED("84sccu12ven74lipf2dljgik4"); //     if (objtype == AGINEDGE)
UNSUPPORTED("5q9qhv35w1rsuiuzqkwgshm3p"); // 	objtype = AGEDGE;
UNSUPPORTED("cdo42je1dwhjo7hka7tk4bu20"); //     if ((d_name_to_id = g->clos->lookup_by_name[objtype]) == ((Dict_t *)0))
UNSUPPORTED("7tkuaa0dee3i2mkwj7ba9bmyj"); // 	d_name_to_id = g->clos->lookup_by_name[objtype] =
UNSUPPORTED("5em5y2jcl61223aawnzfqj4a0"); // 	    agdtopen(g, &LookupByName, Dttree);
UNSUPPORTED("4x4ql6no5kg3qbek3o45fn7nx"); //     if ((d_id_to_name = g->clos->lookup_by_id[objtype]) == ((Dict_t *)0))
UNSUPPORTED("7tmtjlukhbvxyxkd08ijr2m47"); // 	d_id_to_name = g->clos->lookup_by_id[objtype] =
UNSUPPORTED("bnhc1g7rce6un1du4m54v8m5r"); // 	    agdtopen(g, &LookupById, Dttree);
UNSUPPORTED("1y4a6gz63nnj0k1ip32krystr"); //     (*(((Dt_t*)(d_name_to_id))->searchf))((d_name_to_id),(void*)(ent),0000001);
UNSUPPORTED("6d4vd73oyoit1sj5kt1otroy9"); //     (*(((Dt_t*)(d_id_to_name))->searchf))((d_id_to_name),(void*)(ent),0000001);
UNSUPPORTED("c24nfmv9i7o5eoqaymbibp7m7"); // }

throw new UnsupportedOperationException();
}




//3 3r16pkjiksv8i7o961ltxyge6
// static IMapEntry_t *find_isym(Agraph_t * g, int objtype, unsigned long id) 
public static IMapEntry_t find_isym(Agraph_s g, int objtype, int id) {
ENTERING("3r16pkjiksv8i7o961ltxyge6","find_isym");
try {
    _dt_s d;
    IMapEntry_t isym, itemplate = (IMapEntry_t) Memory.malloc(IMapEntry_t.class);
    if (objtype == AGINEDGE)
	objtype = AGEDGE;
    if ((d = (_dt_s) g.getPtr("clos").getArray("lookup_by_id").plus(objtype).getPtr())!=null) {
	itemplate.setInt("id", id);
	isym = (IMapEntry_t) UNSUPPORTED("(IMapEntry_t *) (*(((Dt_t*)(d))->searchf))((d),(void*)(&itemplate),0000004)");
    } else
	isym = null;
    return isym;
} finally {
LEAVING("3r16pkjiksv8i7o961ltxyge6","find_isym");
}
}




//3 foe6bvtujfevsc0f3m8aqln8
// char *aginternalmapprint(Agraph_t * g, int objtype, unsigned long id) 
public static CString aginternalmapprint(Agraph_s g, int objtype, int id) {
ENTERING("foe6bvtujfevsc0f3m8aqln8","aginternalmapprint");
try {
    IMapEntry_t isym;
    if ((isym = find_isym(g, objtype, id))!=null)
	return isym.getCString("str");
    return null;
} finally {
LEAVING("foe6bvtujfevsc0f3m8aqln8","aginternalmapprint");
}
}




//3 5tlg05avf32knqysibbic9jou
// int aginternalmapdelete(Agraph_t * g, int objtype, unsigned long id) 
public static Object aginternalmapdelete(Object... arg) {
UNSUPPORTED("19jjvbvuhgwuct5d89a9klzdn"); // int aginternalmapdelete(Agraph_t * g, int objtype, unsigned long id)
UNSUPPORTED("erg9i1970wdri39osu8hx2a6e"); // {
UNSUPPORTED("4s0k0w2gqymjv4rw9e0p94o4e"); //     IMapEntry_t *isym;
UNSUPPORTED("84sccu12ven74lipf2dljgik4"); //     if (objtype == AGINEDGE)
UNSUPPORTED("5q9qhv35w1rsuiuzqkwgshm3p"); // 	objtype = AGEDGE;
UNSUPPORTED("60rw9rftet6cvrlc5sv6cdvzo"); //     if ((isym = find_isym(g, objtype, id))) {
UNSUPPORTED("6nag2b59botfmnvg4y14s6nez"); // 	(*(((Dt_t*)(g->clos->lookup_by_name[objtype]))->searchf))((g->clos->lookup_by_name[objtype]),(void*)(isym),0000002);
UNSUPPORTED("dsg36gwsles2ud2bgcuw50yi3"); // 	(*(((Dt_t*)(g->clos->lookup_by_id[objtype]))->searchf))((g->clos->lookup_by_id[objtype]),(void*)(isym),0000002);
UNSUPPORTED("avjuzl03gu3mel3wyty6geq69"); // 	agstrfree(g, isym->str);
UNSUPPORTED("6pld2z1bhfc2yevvzc4kxx508"); // 	agfree(g, isym);
UNSUPPORTED("3adr32h5e1fehu4g7j2u24asz"); // 	return (!(0));
UNSUPPORTED("dvgyxsnyeqqnyzq696k3vskib"); //     }
UNSUPPORTED("297p5iu8oro94tdg9v29bbgiw"); //     return (0);
UNSUPPORTED("c24nfmv9i7o5eoqaymbibp7m7"); // }

throw new UnsupportedOperationException();
}




//3 2wanqmzppni4zd3mlb6pkou1k
// void aginternalmapclearlocalnames(Agraph_t * g) 
public static Object aginternalmapclearlocalnames(Object... arg) {
UNSUPPORTED("bkfxi88xlzuzwi4a9iqo8pn28"); // void aginternalmapclearlocalnames(Agraph_t * g)
UNSUPPORTED("erg9i1970wdri39osu8hx2a6e"); // {
UNSUPPORTED("b17di9c7wgtqm51bvsyxz6e2f"); //     int i;
UNSUPPORTED("9lx77yi3grxo0pchpg8wba5f6"); //     IMapEntry_t *sym, *nxt;
UNSUPPORTED("1y1imymtcoka6zqsrmg5hocbt"); //     Dict_t **d_name;
UNSUPPORTED("1lwdd78io6jcv1vyvj9qa9xwd"); //     /* Dict_t **d_id; */
UNSUPPORTED("6qvjz1ziwr3nwocahqvfzw14t"); //     Ag_G_global = g;
UNSUPPORTED("e68mfs18sqlfouc92k24w2fz7"); //     d_name = g->clos->lookup_by_name;
UNSUPPORTED("1upc73ikk3g0k2b325lrtornr"); //     /* d_id = g->clos->lookup_by_id; */
UNSUPPORTED("11oml6vi9s4la6fgcck9ta2y8"); //     for (i = 0; i < 3; i++) {
UNSUPPORTED("6h2zc4egoha1kvb86bjeoan7b"); // 	if (d_name[i]) {
UNSUPPORTED("252siiega2i0vhnempk3jj5gq"); // 	    for (sym = (*(((Dt_t*)(d_name[i]))->searchf))((d_name[i]),(void*)(0),0000200); sym; sym = nxt) {
UNSUPPORTED("9a5rzjs7wyb31qrzau41skcch"); // 		nxt = (*(((Dt_t*)(d_name[i]))->searchf))((d_name[i]),(void*)(sym),0000010);
UNSUPPORTED("620abwca2qrecak9ujprv3erj"); // 		if (sym->str[0] == '%')
UNSUPPORTED("2ys9vkqvwbp3l4dlnzxecpufu"); // 		    aginternalmapdelete(g, i, sym->id);
UNSUPPORTED("6t98dcecgbvbvtpycwiq2ynnj"); // 	    }
UNSUPPORTED("flupwh3kosf3fkhkxllllt1"); // 	}
UNSUPPORTED("dvgyxsnyeqqnyzq696k3vskib"); //     }
UNSUPPORTED("c24nfmv9i7o5eoqaymbibp7m7"); // }

throw new UnsupportedOperationException();
}




//3 exx9lnei1gnd60cuddc52z7i9
// static void closeit(Dict_t ** d) 
public static Object closeit(Object... arg) {
UNSUPPORTED("dg5p1tjrd085naw1mo4ichi6q"); // static void closeit(Dict_t ** d)
UNSUPPORTED("erg9i1970wdri39osu8hx2a6e"); // {
UNSUPPORTED("b17di9c7wgtqm51bvsyxz6e2f"); //     int i;
UNSUPPORTED("11oml6vi9s4la6fgcck9ta2y8"); //     for (i = 0; i < 3; i++) {
UNSUPPORTED("dx4pjim9y4f2jtcu836j38fq8"); // 	if (d[i]) {
UNSUPPORTED("2zjj5fsuyj57whze7pm4bef4e"); // 	    dtclose(d[i]);
UNSUPPORTED("5z84h9gs3klhayayencls3cd3"); // 	    d[i] = ((Dict_t *)0);
UNSUPPORTED("flupwh3kosf3fkhkxllllt1"); // 	}
UNSUPPORTED("dvgyxsnyeqqnyzq696k3vskib"); //     }
UNSUPPORTED("c24nfmv9i7o5eoqaymbibp7m7"); // }

throw new UnsupportedOperationException();
}




//3 5dw1m5wgietdxy22txx0l20ph
// void aginternalmapclose(Agraph_t * g) 
public static Object aginternalmapclose(Object... arg) {
UNSUPPORTED("bdxp6h1xs4z2wt83fv2a3w0y2"); // void aginternalmapclose(Agraph_t * g)
UNSUPPORTED("erg9i1970wdri39osu8hx2a6e"); // {
UNSUPPORTED("6qvjz1ziwr3nwocahqvfzw14t"); //     Ag_G_global = g;
UNSUPPORTED("9mn11z09mil44jhvfaju1n7i5"); //     closeit(g->clos->lookup_by_name);
UNSUPPORTED("74lp49loz9ng7u2mjovdv1wd5"); //     closeit(g->clos->lookup_by_id);
UNSUPPORTED("c24nfmv9i7o5eoqaymbibp7m7"); // }

throw new UnsupportedOperationException();
}


}