--****************************************************
--Executar esse script via psql

-- docker exec -it [ID_CONTAINER] /bin/bash
-- su - postgres
-- psql
--****************************************************

-- cria banco
CREATE DATABASE carteiraamiga;

-- cria esquema
\connect carteiraamiga;
CREATE SCHEMA carteiraamiga;

-- cria role com privilégios para todas as operações
CREATE ROLE role_adm;
ALTER ROLE role_adm SET search_path TO carteiraamiga, public;
GRANT ALL PRIVILEGES ON DATABASE carteiraamiga TO role_adm;
GRANT ALL PRIVILEGES ON SCHEMA carteiraamiga TO role_adm;

-- cria usuário geral da aplicação (terá privilégios para todas as operações)
CREATE USER user_admin WITH PASSWORD 'ca-admin' IN ROLE role_adm;

