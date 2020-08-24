-module(calculator).
-export([calc/1]).	% exported only for being able to use it
-compile(debug_info).

-include_lib("proper/include/proper.hrl").

-type t() :: integer() | {'a',t(),t()} | {'d',t(),t()}.

prop_calculator() ->
  ?FORALL(T, t(), ?IMPLIES(divSubTerms(T), calc(T) =/= nothing)).

divSubTerms(I) when is_integer(I) -> true;
divSubTerms({d,_,0}) -> false;
divSubTerms({_,X,Y}) -> divSubTerms(X) andalso divSubTerms(Y).

calc(I) when is_integer(I) -> I;
calc({a,X,Y}) ->
  calc(X) + calc(Y);
calc({d,X,Y}) ->
  case calc(Y) of
    0 -> nothing;
    R -> calc(X) div R
  end.

