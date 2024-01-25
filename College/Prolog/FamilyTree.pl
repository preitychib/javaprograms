gender(a,male).
gender(b,female).
gender(c,male).
gender(d,female).
gender(e,male).
gender(f,female).
gender(h,male).
gender(g,female).
gender(i,male).
gender(j,female).
gender(k,male).
gender(l,female).
gender(mm,male).
gender(n,female).
gender(o,female).
gender(p,male).


father(a,e). mother(b,e).
father(c,f). mother(d,f).
father(e,g). mother(f,g).
father(h,j). father(h,k).
mother(g,j). mother(g,k).
father(i,mm). father(i,n).
mother(j,mm). mother(j,n).
father(k,o). father(k,p).
mother(l,o). mother(l,p).


parent(par,child) :- mother(par,child); father(par,child).
sibiling(child1,child2) :- parent(par,child1), parent(par,child2), child1\=child2.

son(Son,Parent) :- parent(Parent,Son), gender(Son,male).
daughter(Daughter,Parent) :- parent(Parent,Daughter), gender(Daughter,female).

brother(Bro,Sibling) :- parent(Parent,Bro),parent(Parent,Sibling), gender(Bro,male).
sister(Sister,Sibling) :- parent(Parent,Sister),parent(Parent,Sibling), gender(Sister,female).

ancestor(Ancestor,Desc) :- parent(Ancestor,Desc).
ancestor(Ancestor,Desc) :- parent(Ancestor,Intermid), ancestor(Intermid,Desc).

cousin(child1,child2) :- 
    parent(Parent1, child1), 
    parent(Parent2,child2),
    Parent1 \= Parent2,
    ancestor(Ancestor,child1), 
    ancestor(Ancestor,child2).

uncle(Uncle,child) :-
    father(Father, child), 
    Father \= Uncle,
    parent(Parent,Father),
    parent(Parent,Uncle),
    gender(Uncle,male).

aunt(Aunt,child) :-
    mother(Mother, child), 
    Mother \= Aunt,
    parent(Parent,Mother),
    parent(Parent,Aunt),
    gender(Aunt,female).
