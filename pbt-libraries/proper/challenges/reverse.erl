-module(reverse).

-include_lib("proper/include/proper.hrl").

prop_rev() ->
  ?FORALL(L, list(integer()), lists:reverse(L) =:= L).
