-module(lengthlist).

-include_lib("proper/include/proper.hrl").

prop_lengthlist() ->
    ?FORALL(L, ?LET(N, range(1,100), vector(N,range(0,1000))),
	    lists:max(L) < 900).
