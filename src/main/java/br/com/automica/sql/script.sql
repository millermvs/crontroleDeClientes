-- 1) Tabela de endereços
CREATE TABLE enderecos (   -- Cria a tabela chamada "enderecos" no schema "public"
  id           uuid PRIMARY KEY DEFAULT gen_random_uuid(),  -- Chave primária do tipo UUID, gerada automaticamente
  cep          text    NOT NULL,                           -- CEP obrigatório
  rua          text    NOT NULL,                           -- Nome da rua obrigatório
  numero       text    NOT NULL,                           -- Número da residência obrigatório (pode ter letras, por isso text)
  bairro       text    NOT NULL,                           -- Bairro obrigatório
  cidade       text    NOT NULL,                           -- Cidade obrigatória
  estado       text    NOT NULL,                           -- Estado obrigatório
  pais         text    NOT NULL,                           -- País obrigatório
  complemento  text,                                       -- Campo opcional (ex: bloco, apto)
  created_at   timestamptz NOT NULL DEFAULT now()          -- Data/hora de criação do registro, padrão: momento atual
);

-- 2) Tabela de clientes
CREATE TABLE clientes (    -- Cria a tabela "clientes"
  id             uuid PRIMARY KEY DEFAULT gen_random_uuid(),    -- ID único do cliente (UUID automático)
  nome           text    NOT NULL,                              -- Nome do cliente (obrigatório)
  cpf            text    NOT NULL UNIQUE,                       -- CPF (único, não pode repetir)
  data_nasc      date,                                          -- Data de nascimento (tipo date)
  telefone       text,                                          -- Telefone (texto para suportar formatos diferentes)
  endereco_id    uuid REFERENCES enderecos(id) ON DELETE SET NULL, 
  -- FK: liga ao endereço. Se o endereço for deletado, este campo vira NULL (não apaga o cliente)
  cliente_ativo  boolean NOT NULL DEFAULT false,                 -- Indica se o cliente está ativo (padrão false)
  created_at     timestamptz NOT NULL DEFAULT now(),            -- Data/hora de criação
  -- CPF com exatamente 11 dígitos numéricos
  CONSTRAINT clientes_cpf_digits CHECK (cpf ~ '^[0-9]{11}$')    -- Regra: só aceita CPF com 11 dígitos numéricos
);

-- 3) Tabela de funcionários
CREATE TABLE funcionarios (  -- Cria a tabela "funcionarios"
  id                    uuid PRIMARY KEY DEFAULT gen_random_uuid(), -- ID único do funcionário (UUID automático)
  nome                  text    NOT NULL,                           -- Nome do funcionário
  data_nasc             date,                                       -- Data de nascimento
  cpf                   text    NOT NULL UNIQUE,                    -- CPF (único)
  telefone              text,                                       -- Telefone
  endereco_id           uuid REFERENCES enderecos(id) ON DELETE SET NULL,
  -- FK: liga ao endereço. Se o endereço for deletado, este campo vira NULL
  ainda_eh_funcionario  boolean NOT NULL DEFAULT true,              -- Indica se ainda trabalha na empresa (padrão true)
  created_at            timestamptz NOT NULL DEFAULT now(),         -- Data/hora de criação
  CONSTRAINT funcionarios_cpf_digits CHECK (cpf ~ '^[0-9]{11}$')    -- Regra: CPF com 11 dígitos numéricos
);