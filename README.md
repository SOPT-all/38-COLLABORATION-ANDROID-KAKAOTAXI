# 38-COLLABORATION-ANDROID-KAKAOTAXI
38기 LET'S SPOT 합동 세미나 안드로이드 4조 카카오택시 🚕

<br/>

## **✨ Contributors**

|            🚕이지민(LEAD)<br/>[@vahkjsdf](https://github.com/vahkjsdf)            |            🚕송서현<br/>[@Hiimynameiss](https://github.com/Hiimynameiss)            |             🚕조수민<br/>[@chosumin432](https://github.com/chosumin432)             |               🚕최은지<br/>[@chldmswll](https://github.com/chldmswll)               |
|:--------------------------------------------------------------------------------:|:--------------------------------------------------------------------------------:|:--------------------------------------------------------------------------------:|:--------------------------------------------------------------------------------:|
| <img src="https://avatars.githubusercontent.com/u/130419090?v=4" height="200" /> | <img src="https://avatars.githubusercontent.com/u/199242635?v=4" height="200" /> | <img src="https://avatars.githubusercontent.com/u/271240568?v=4" height="200" /> | <img src="https://avatars.githubusercontent.com/u/182719623?v=4" height="200" /> |
|                                     `목적지 검색`                                     |                                `택시 호출`, `목적지 확인`                                 |                            `택시 도착`                          |                                       `홈`                                        |

<br/>

## **⚒️ Tech Stacks**

| 항목 | 기술 스택                                                  |
| :--- |:-------------------------------------------------------|
| Architecture | Google Recommended Architecture                        |
| Pattern | MVVM                                                   |
| DI | Manual Dependency Injection                            |
| Asynchronous | Coroutine, Flow                                        |
| Network | Retrofit2, OkHttp                                      |
| Navigation | Single Activity Architecture (SAA), Jetpack Navigation |
| UI Framework | Jetpack Compose                                        |
| Logging | Timber                                                 |

<br/>

## 📸 시연 영상

> 추후 업로드 예정



<br/>

## **📜 Convention**

- [**Github Convention**](https://www.notion.so/35783e5519b380679edae7891f2e0d1a?source=copy_link)
- [**Naming Convention**](https://www.notion.so/35783e5519b380328ab2de33a2245c33?source=copy_link)

<br/>

## **🗂️ Project Structure**

```text
kakaotaxi
├── 📂 core
│   ├── 📂 designsystem
│   │   ├── 📁 component    # 공통 UI 컴포넌트
│   │   └── 📁 theme        # 색상, 타이포, 테마
│   ├── 📁 di               # 의존성 주입(ViewModelFactory)
│   ├── 📁 extensions       # 확장함수
│   ├── 📁 navigation       # 네비게이션 라우트 정의
│   ├── 📁 network          # 네트워크 설정
│   └── 📁 util             # 공통 유틸
│
├── 📂 data
│   ├── 📁 mapper           # DTO → Model 변환
│   ├── 📁 model            # 도메인 모델
│   ├── 📂 remote
│   │   ├── 📂 datasource  
│   │   │   ├── 📁 api      # DataSource 인터페이스
│   │   │   └── 📁 impl     # DataSource 구현체
│   │   ├── 📁 dto          # API 요청/응답 DTO
│   │   └── 📁 service      # Retrofit Service 인터페이스
│   └── 📂 repository
│       ├── 📁 api          # Repository 인터페이스
│       └── 📁 impl         # Repository 구현체
│
└── 📂 presentation         
    ├── 📁 arrival
    ├── 📁 call
    ├── 📁 home
    ├── 📁 main             # MainActivity, 네비게이션 정의
    ├── 📁 search
    └── 📁 ...
