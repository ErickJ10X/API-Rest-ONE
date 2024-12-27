alter table pacientes add column activo boolean;
update pacientes set activo = true;
alter table pacientes alter column activo set not null;