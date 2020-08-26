-module(large_union_list).

-include_lib("proper/include/proper.hrl").

prop_large_union_list() ->
  ?FORALL(L, list(list(integer())), length(lists:usort(lists:append(L))) < 5).
