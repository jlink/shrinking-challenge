-module(distinct).

-include_lib("proper/include/proper.hrl").

prop_distinct() -> % make sure that the list has length at least 3
    ?FORALL(L, ?LET(N, pos_integer(), vector(N+2, integer())),
	    lists:sort(L) =/= lists:usort(L)).
