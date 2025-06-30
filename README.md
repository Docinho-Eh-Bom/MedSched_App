## Funcionalidades
- Login e cadastro de usuários
- Listagem de médicos e pacientes
- Visualização de consultas agendadas e finalizadas
- Armazenamento local com RoomDB
- Integração com API remota via Retrofit

## Utilizado
- Retrofit (HTTP Client)
- RoomDB (Banco local)
- Fragments
- RecyclerView

## API
A API (que era para consumir, só que muito mais simplificada):
https://medsched-api-1.onrender.com

## Estrutura do Projeto
MedSched_App/
├── model/ # Entidades Room (Consult, Medic, Patient)
├── req_res/ # Modelos de requisição e resposta Retrofit
├── retroft/ # RetrofitClient e interface da API
├── screen/ # Fragments, Adapters e List/Detail Activities
├── db_room/ # RoomDatabase e DAOs
├── repo/ # MedSched Repository e MapToRoom
├──activities/ # Home,Login e Register activities
└── StartPage.java

