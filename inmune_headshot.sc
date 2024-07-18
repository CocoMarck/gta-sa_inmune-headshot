SCRIPT_START
{
NOP



// Funcion principal, en bucle
inmune_headshot:
WAIT 0
    
// Obtener player
LVAR_INT scplayer
GET_PLAYER_CHAR 0 scplayer

// Obtener peds/personajes cerca del player, en un radio de: 500
CONST_FLOAT radius 500.0
IF ARE_ANY_CHARS_NEAR_CHAR scplayer, radius
    // Si hay peatones cerca
    // PRINT_STRING_NOW "Hay peatones cerca", 1000
    
    // Coordenadas de player
    LVAR_FLOAT x, y, z
    GET_CHAR_COORDINATES scplayer, x, y, z
    
    // Obtener de forma aleatoria algun char
    LVAR_INT char
    GET_RANDOM_CHAR_IN_SPHERE_NO_SAVE_RECURSIVE x, y, z, radius, 1, 0, char
    
    // Que el ped aguente tiros en la cabeza
    IF NOT char = -1
        // PRINT_FORMATTED_NOW "%i %i", 1000, char, scplayer
        SET_CHAR_SUFFERS_CRITICAL_HITS char, False
    ELSE
        WAIT 0
    ENDIF
ELSE
    // No hay peatones cerca, no hacer nada
    PRINT_STRING_NOW "No hay peatones cerca", 1000
ENDIF



// Bucle infinito a la funcion
GOTO inmune_headshot
}
SCRIPT_END
