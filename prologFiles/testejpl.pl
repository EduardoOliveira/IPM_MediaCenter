:- ensure_loaded('C:/Users/Chen/Desktop/ISCTE/TSI/Prolog/cf_solve/cf_solve.pl').


movie('The Lord of the Rings: The Return of the King', ['true', 'false', 'false', 'false', 'false', 'false', 'false', 'false', 'false', 'true'], 'Adventure'). %plus_18
movie('Goodfellas', ['false', 'false', 'false', 'false', 'false', 'false', 'false', 'false', 'false', 'true'], 'Biography'). %parental_guide
movie('Casablanca', ['false', 'false', 'false', 'false', 'false', 'false', 'false', 'false', 'false', 'false'], 'Drama').
movie('The Lord of the Rings: The Two Towers', ['true', 'false', 'false', 'false', 'false', 'false', 'false', 'false', 'false', 'true'], 'Action').

%General audience - 0 to 8
general([X|G]):-
	movie(X, ['false', 'false', 'false', 'false', 'false', 'false', 'false', 'false', 'false', 'false'], G).

%Parental Guidance Suggested - 9 to 13
parental_guidance([X|G]):-
	movie(X, [_, 'false', 'false', 'false', 'false', 'false', _, 'false', _, _], G).

%Parents Strongly Cautioned - 14 to 17
parents_cautioned([X|G]):-
	movie(X, [_, _, _, 'false', 'false', _, _, 'false', _, _], G).

%Plus 18
plus_18([X|G]):-
	%movie(X, ['true', 'true', 'true', 'true', 'true', 'true', 'true', 'true', 'true', 'true'], G),
	movie(X, _, G).


introduce_emotion(X):-
	assert(emotion(X)).


%Regras com factor de Confiança
% Emotion -> Excited
if (emotion(excited))
then genre(action) ? 0.8.
if (emotion(excited))
then genre(adventure) ? 0.7.
if (emotion(excited))
then genre(animation) ? 0.6.
if (emotion(excited))
then genre(biography) ? 0.0.
if (emotion(excited))
then genre(crime) ? 0.0.
if (emotion(excited))
then genre(comedy) ? 0.6.
if (emotion(excited))
then genre(documentary) ? 0.0.
if (emotion(excited))
then genre(drama) ? 0.0.
if (emotion(excited))
then genre(family) ? 0.6.
if (emotion(excited))
then genre(fantasy) ? 0.6.
if (emotion(excited))
then genre(film_noir) ? 0.0.
if (emmotion(excited))
then genre(history) ? 0.0.
if (emotion(excited))
then genre(horror) ? 0.7.
if (emotion(excited))
then genre(music) ? 0.6.
if (emotion(excited))
then genre(musical) ? 0.0.
if (emotion(excited))
then genre(mistery) ? 0.0.
if (emotion(excited))
then genre(romance) ? 0.0.
if (emotion(excited))
then genre(sci_fi) ? 0.6.
if (emotion(excited))
then genre(sport) ? 0.3.
if (emotion(excited))
then genre(thriller) ? 0.3. %MUDAR PARA 0.9
if (emotion(excited))
then genre(war) ? 0.0.
if (emotion(excited))
then genre(western) ? 0.0.

%Emotion -> Pissed_Of
if (emotion(pissed_Of))
then genre(action) ? 0.7.
if (emotion(pissed_Of))
then genre(adventure) ? 0.0.
if (emotion(pissed_Of))
then genre(animation) ? 0.0.
if (emotion(pissed_Of))
then genre(biography) ? 0.0.
if (emotion(pissed_Of))
then genre(crime) ? 0.6.
if (emotion(pissed_Of))
then genre(comedy) ? 0.4.
if (emotion(pissed_Of))
then genre(documentary) ? 0.0.
if (emotion(pissed_Of))
then genre(drama) ? 0.7.
if (emotion(pissed_Of))
then genre(family) ? 0.0.
if (emotion(pissed_Of))
then genre(fantasy) ? 0.5.
if (emotion(pissed_Of))
then genre(film_noir) ? 0.0.
if (emotion(pissed_Of))
then genre(history) ? 0.0.
if (emotion(pissed_Of))
then genre(horror) ? 0.0.
if (emotion(pissed_Of))
then genre(music) ? 0.4.
if (emotion(pissed_Of))
then genre(musical) ? 0.0.
if (emotion(pissed_Of))
then genre(mistery) ? 0.7.
if (emotion(pissed_Of))
then genre(romance) ? 0.7.
if (emotion(pissed_Of))
then genre(sci_fi) ? 0.0.
if (emotion(pissed_Of))
then genre(sport) ? 0.0.
if (emotion(pissed_Of))
then genre(thriller) ? 0.0.
if (emotion(pissed_Of))
then genre(war) ? 0.0.
if (emotion(pissed_Of))
then genre(western) ? 0.0.

%Emotion -> Thoughtful
if(emotion(thoughtful))
then genre(action) ? 0.0.
if(emotion(thoughtful))
then genre(adventure) ? 0.0.
if(emotion(thoughtful))
then genre(animation) ? 0.0.
if(emotion(thoughtful))
then genre(biography) ? 0.0.
if(emotion(thoughtful))
then genre(crime) ? 0.8.
if(emotion(thoughtful))
then genre(comedy) ? 0.0.
if(emotion(thoughtful))
then genre(documentary) ? 0.0.
if(emotion(thoughtful))
then genre(drama) ? 0.7.
if(emotion(thoughtful))
then genre(family) ? 0.0.
if(emotion(thoughtful))
then genre(fantasy) ? 0.0.
if(emotion(thoughtful))
then genre(film_noir) ? 0.0.
if(emotion(thoughtful))
then genre(history) ? 0.0.
if(emotion(thoughtful))
then genre(horror) ? 0.0.
if(emotion(thoughtful))
then genre(music) ? 0.0.
if(emotion(thoughtful))
then genre(musical) ? 0.4.
if(emotion(thoughtful))
then genre(mistery) ? 0.8.
if(emotion(thoughtful))
then genre(romance) ? 0.7.
if(emotion(thoughtful))
then genre(sci_fi) ? 0.0.
if(emotion(thoughtful))
then genre(sport) ? 0.0.
if(emotion(thoughtful))
then genre(thriller) ? 0.9.
if(emotion(thoughtful))
then genre(war) ? 0.5.
if(emotion(thoughtful))
then genre(western) ? 0.0.

%Emotion -> Nostalgic
if(emotion(thoughtful))
then genre(action) ? 0.0.
if(emotion(thoughtful))
then genre(adventure) ? 0.0.
if(emotion(thoughtful))
then genre(animation) ? 0.7.
if(emotion(thoughtful))
then genre(biography) ? 0.5.
if(emotion(thoughtful))
then genre(crime) ? 0.0.
if(emotion(thoughtful))
then genre(comedy) ? 0.0.
if(emotion(thoughtful))
then genre(documentary) ? 0.4.
if(emotion(thoughtful))
then genre(drama) ? 0.0.
if(emotion(thoughtful))
then genre(family) ? 0.5.
if(emotion(thoughtful))
then genre(fantasy) ? 0.0.
if(emotion(thoughtful))
then genre(film_noir) ? 0.4.
if(emotion(thoughtful))
then genre(history) ? 0.5.
if(emotion(thoughtful))
then genre(horror) ? 0.0.
if(emotion(thoughtful))
then genre(music) ? 0.0.
if(emotion(thoughtful))
then genre(musical) ? 0.0.
if(emotion(thoughtful))
then genre(mistery) ? 0.0.
if(emotion(thoughtful))
then genre(romance) ? 0.7.
if(emotion(thoughtful))
then genre(sci_fi) ? 0.0.
if(emotion(thoughtful))
then genre(sport) ? 0.0.
if(emotion(thoughtful))
then genre(thriller) ? 0.0.
if(emotion(thoughtful))
then genre(war) ? 0.5.
if(emotion(thoughtful))
then genre(western) ? 0.6.


%Emotion -> Meh
if(emotion(thoughtful))
then genre(action) ? 0.8.
if(emotion(thoughtful))
then genre(adventure) ? 0.7.
if(emotion(thoughtful))
then genre(animation) ? 0.0.
if(emotion(thoughtful))
then genre(biography) ? 0.0.
if(emotion(thoughtful))
then genre(crime) ? 0.0.
if(emotion(thoughtful))
then genre(comedy) ? 0.8.
if(emotion(thoughtful))
then genre(documentary) ? 0.7.
if(emotion(thoughtful))
then genre(drama) ? 0.9.
if(emotion(thoughtful))
then genre(family) ? 0.7.
if(emotion(thoughtful))
then genre(fantasy) ? 0.0.
if(emotion(thoughtful))
then genre(film_noir) ? 0.0.
if(emotion(thoughtful))
then genre(history) ? 0.0.
if(emotion(thoughtful))
then genre(horror) ? 0.7.
if(emotion(thoughtful))
then genre(music) ? 0.5.
if(emotion(thoughtful))
then genre(musical) ? 0.4.
if(emotion(thoughtful))
then genre(mistery) ? 0.0.
if(emotion(thoughtful))
then genre(romance) ? 0.8.
if(emotion(thoughtful))
then genre(sci_fi) ? 0.7.
if(emotion(thoughtful))
then genre(sport) ? 0.8.
if(emotion(thoughtful))
then genre(thriller) ? 0.6.
if(emotion(thoughtful))
then genre(war) ? 0.0.
if(emotion(thoughtful))
then genre(western) ? 0.0.
