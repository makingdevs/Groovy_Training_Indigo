CREATE TABLE IF NOT EXISTS USER_STORY(
    ID BIGINT AUTO_INCREMENT PRIMARY KEY,
    DATE_CREATED TIMESTAMP NOT NULL,
    DESCRIPTION VARCHAR(255) NOT NULL,
    EFFORT INTEGER NOT NULL,
    LAST_UPDATED TIMESTAMP NOT NULL,
    PRIORITY INTEGER NOT NULL,
    PROJECT_ID BIGINT NOT NULL
);        
               
INSERT INTO USER_STORY(ID, DATE_CREATED, DESCRIPTION, EFFORT, LAST_UPDATED, PRIORITY, PROJECT_ID) VALUES
(1, TIMESTAMP '2014-02-12 13:34:19.591', 'Como usuario Quiero emitir facturas De tal manera que pueda entregarlas en XML y PDF', 5, TIMESTAMP '2014-02-12 13:34:19.591', 1, 1),
(2, TIMESTAMP '2014-02-12 13:34:55.822', STRINGDECODE('Como usuario de finanzas Quiero un estado financiero De tal manera que pueda ver la facturaci\u00f3n mensual'), 3, TIMESTAMP '2014-02-12 13:34:55.822', 2, 1),
(3, TIMESTAMP '2014-02-12 13:38:18.29', 'Como product owner Deseo administrar proyectos De tal manera que pueda crearlos y visualizarlos', 3, TIMESTAMP '2014-02-12 13:38:18.29', 1, 4),
(4, TIMESTAMP '2014-02-12 13:38:47.109', STRINGDECODE('Como product owner Deseo agregar la descripci\u00f3n de una funcionalidad De tal manera que pueda identificarla como una historia de usuario'), 3, TIMESTAMP '2014-02-12 13:38:47.109', 2, 4),
(5, TIMESTAMP '2014-02-12 13:39:06.799', 'Como miembro del equipo Deseo agregar tareas De tal manera que puedan ser parte de una historia de usuario', 1, TIMESTAMP '2014-02-12 13:39:06.799', 3, 4),
(6, TIMESTAMP '2014-02-12 13:39:26.522', 'Como miembro del equipo Deseo unirme al equipo De tal manera que agregar tareas y colaborar en un proyecto', 1, TIMESTAMP '2014-02-12 13:39:26.522', 4, 4),
(7, TIMESTAMP '2014-02-12 13:39:48.728', 'Como miembro del equipo Deseo un tablero con las tareas de una proyecto De tal manera que pueda visualizar el estado actual del proyecto', 5, TIMESTAMP '2014-02-12 13:39:48.728', 5, 4);