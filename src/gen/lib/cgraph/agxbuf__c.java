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

public class agxbuf__c {


//3 688cb39nv214oqldmhd8roirz
// void agxbinit(agxbuf * xb, unsigned int hint, unsigned char *init) 
public static Object agxbinit(Object... arg) {
UNSUPPORTED("4l5fskgdbcbqssdclb6lwckwe"); // void agxbinit(agxbuf * xb, unsigned int hint, unsigned char *init)
UNSUPPORTED("erg9i1970wdri39osu8hx2a6e"); // {
UNSUPPORTED("3ctz7esjgupftv01eshc2dhx2"); //     if (init) {
UNSUPPORTED("7ccqm4ipez0mmdk6bv50shi8z"); // 	xb->buf = init;
UNSUPPORTED("bgb2e1tveztx6w0nuo6t6kxbd"); // 	xb->dyna = 0;
UNSUPPORTED("c07up7zvrnu2vhzy6d7zcu94g"); //     } else {
UNSUPPORTED("49jhfm9yw3megswomc4gzzgd7"); // 	if (hint == 0)
UNSUPPORTED("5h1ggxg5ypn75rue18vgizp12"); // 	    hint = BUFSIZ;
UNSUPPORTED("bwuph2kus95n04yy45ff0ygwg"); // 	xb->dyna = 1;
UNSUPPORTED("rowpmdm8bmtos5w0uxjinsts"); // 	xb->buf = (unsigned char*)malloc((hint)*sizeof(unsigned char));
UNSUPPORTED("dvgyxsnyeqqnyzq696k3vskib"); //     }
UNSUPPORTED("1vqjbr0qaxnp1tks2ilwqgn3g"); //     xb->eptr = xb->buf + hint;
UNSUPPORTED("dtbxbzhkw05lut0ozk9a49lw6"); //     xb->ptr = xb->buf;
UNSUPPORTED("5ymin98xo0ermvpyhsuo8xwim"); //     *xb->ptr = '\0';
UNSUPPORTED("c24nfmv9i7o5eoqaymbibp7m7"); // }

throw new UnsupportedOperationException();
}




//3 lu77u8ojbx0os3eapudi7k0e
// int agxbmore(agxbuf * xb, unsigned int ssz) 
public static Object agxbmore(Object... arg) {
UNSUPPORTED("1zbuuoy42nrbwgmz0kzwxatml"); // int agxbmore(agxbuf * xb, unsigned int ssz)
UNSUPPORTED("erg9i1970wdri39osu8hx2a6e"); // {
UNSUPPORTED("ayzlme0ebe3j87lpz076cg2vq"); //     int cnt;			/* current no. of characters in buffer */
UNSUPPORTED("71r9w1f25l9h79jodjer7my8a"); //     int size;			/* current buffer size */
UNSUPPORTED("2bckq0rejaf94iovglem6hqko"); //     int nsize;			/* new buffer size */
UNSUPPORTED("dmokvf86b5kj3srnwwbr7ebmc"); //     unsigned char *nbuf;	/* new buffer */
UNSUPPORTED("347vqdgen21gpinnet4lkk7gk"); //     size = xb->eptr - xb->buf;
UNSUPPORTED("49rolm7orqt4aw3uud529g4qc"); //     nsize = 2 * size;
UNSUPPORTED("svb97awsbpziy0qhoaq68u7b"); //     if (size + (int)ssz > nsize)
UNSUPPORTED("7ykdy1xuvrmibubukfxhfmz91"); // 	nsize = size + ssz;
UNSUPPORTED("bfinudkdiev8mwo6udbayoaex"); //     cnt = xb->ptr - xb->buf;
UNSUPPORTED("4cmq49lu7qhmui59rl36qd6fr"); //     if (xb->dyna) {
UNSUPPORTED("8vf8arbygb0610hkc403uiror"); // 	nbuf = realloc(xb->buf, nsize);
UNSUPPORTED("c07up7zvrnu2vhzy6d7zcu94g"); //     } else {
UNSUPPORTED("3sajbfvh0ecfy6mdfwrwrojl6"); // 	nbuf = (unsigned char*)malloc((nsize)*sizeof(unsigned char));
UNSUPPORTED("do1ts7n0vopj00hs85yw95qjx"); // 	memcpy(nbuf, xb->buf, cnt);
UNSUPPORTED("bwuph2kus95n04yy45ff0ygwg"); // 	xb->dyna = 1;
UNSUPPORTED("dvgyxsnyeqqnyzq696k3vskib"); //     }
UNSUPPORTED("5a5gutjqda6fhdylt7vi64g71"); //     xb->buf = nbuf;
UNSUPPORTED("dodqzfdb41641741187lm9aci"); //     xb->ptr = xb->buf + cnt;
UNSUPPORTED("e45cf41wsuzfjfi2my7jn7odp"); //     xb->eptr = xb->buf + nsize;
UNSUPPORTED("5oxhd3fvp0gfmrmz12vndnjt"); //     return 0;
UNSUPPORTED("c24nfmv9i7o5eoqaymbibp7m7"); // }

throw new UnsupportedOperationException();
}




//3 7q04bdt3el30gta4bdtl0cr8s
// int agxbput_n(agxbuf * xb, const char *s, unsigned int ssz) 
public static Object agxbput_n(Object... arg) {
UNSUPPORTED("xj5zv8tlevqufi7kllkj6uu1"); // int agxbput_n(agxbuf * xb, const char *s, unsigned int ssz)
UNSUPPORTED("erg9i1970wdri39osu8hx2a6e"); // {
UNSUPPORTED("6q0wy2t9qi11079j0wyuhsmiw"); //     if (xb->ptr + ssz > xb->eptr)
UNSUPPORTED("82p9dlopf5tuzmyy5454sv4mm"); // 	agxbmore(xb, ssz);
UNSUPPORTED("9tvk5ztcu9lg2u40sfmevitl2"); //     memcpy(xb->ptr, s, ssz);
UNSUPPORTED("2wy6om6o92zevnnevl5v0pr0c"); //     xb->ptr += ssz;
UNSUPPORTED("dzondrrxi2pe7xy72r0jstd20"); //     return ssz;
UNSUPPORTED("c24nfmv9i7o5eoqaymbibp7m7"); // }

throw new UnsupportedOperationException();
}




//3 12y895mwxr60srt40guuma6j5
// int agxbput(agxbuf * xb, const char *s) 
public static Object agxbput(Object... arg) {
UNSUPPORTED("3oqw629wj8yulgtvwwlxn8iyi"); // int agxbput(agxbuf * xb, const char *s)
UNSUPPORTED("erg9i1970wdri39osu8hx2a6e"); // {
UNSUPPORTED("dmstj6pqesin7a4ufrtut65t5"); //     unsigned int ssz = strlen(s);
UNSUPPORTED("7i8gvckml5cbfmuhw2pjs8czl"); //     return agxbput_n(xb, s, ssz);
UNSUPPORTED("c24nfmv9i7o5eoqaymbibp7m7"); // }

throw new UnsupportedOperationException();
}




//3 2zlar00xk0a2nnqcmjb587kvc
// void agxbfree(agxbuf * xb) 
public static Object agxbfree(Object... arg) {
UNSUPPORTED("3zwjoplc2wp6x7lb2b5g59pl8"); // void agxbfree(agxbuf * xb)
UNSUPPORTED("erg9i1970wdri39osu8hx2a6e"); // {
UNSUPPORTED("da8gv3dgf6bnks54n9mnlgzxk"); //     if (xb->dyna)
UNSUPPORTED("62irfu7vrq2ewolixn0ksp5f6"); // 	free(xb->buf);
UNSUPPORTED("c24nfmv9i7o5eoqaymbibp7m7"); // }

throw new UnsupportedOperationException();
}




//3 cn9iiltxtts5ijjpixwt2uziu
// int agxbpop(agxbuf * xb) 
public static Object agxbpop(Object... arg) {
UNSUPPORTED("1hje4ns6ul7cj52y9n9wlgkkc"); // int agxbpop(agxbuf * xb)
UNSUPPORTED("erg9i1970wdri39osu8hx2a6e"); // {
UNSUPPORTED("53xzwretgdbd0atozc0w6hagb"); //     int c;
UNSUPPORTED("a6gx1f2k9r1jreuxvg1n7jpiw"); //     if (xb->ptr > xb->buf) {
UNSUPPORTED("asuii09e2jl1px5timbisq3sx"); // 	c = *xb->ptr--;
UNSUPPORTED("7q6l09k0u87z31e0nmv2lwr94"); // 	return c;
UNSUPPORTED("2lkbqgh2h6urnppaik3zo7ywi"); //     } else
UNSUPPORTED("8d9xfgejx5vgd6shva5wk5k06"); // 	return -1;
UNSUPPORTED("c24nfmv9i7o5eoqaymbibp7m7"); // }

throw new UnsupportedOperationException();
}


}