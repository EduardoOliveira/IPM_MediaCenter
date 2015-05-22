findall(Ar,(current_prolog_flag( N, V),
            term_to_atom( V, Va),
            jpl_new( '[Ljava.lang.String;', [N,Va], Ar)
        ),
        Ars),
    jpl_new( '[[Ljava.lang.String;', Ars, Ac),
    jpl_datums_to_array( [name,value], Ah),
    jpl_new( 'javax.swing.JFrame', ['current_prolog_flag'], F),
    jpl_call( F, getContentPane, [], CP),
    jpl_new( 'javax.swing.JTable', [Ac,Ah], T),
    jpl_new( 'javax.swing.JScrollPane', [T], SP),
    jpl_call( CP, add, [SP,'Center'], _),
    jpl_call( F, setSize, [600,400], _).


jpl_datums_to_array( Ds, A) :-
    ground( Ds),
    jpl_datums_to_most_specific_common_ancestor_type( Ds, T),
    jpl_new( array(T), Ds, A).
