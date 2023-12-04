# JWT 설정 파일 필요

JWT Secret Key를 설정해야 합니다.

{Package Root}/resources/jwt.yml 파일을 생성하고 아래와 같이 작성합니다.

```yaml
secret-key: {JWT Secret Key}
expiration-hours: {만료 시간}
issuer: {작성자}
```
### 예시
```yaml
secret-key: V%c)6_Y}fZHD7vtT/N-ws%Nt$-zy%E%(1e]I>%Efr{h[vxb!Z5<9A58HwrmF{4haY{pnfeCGTWhjy,MK9(4Y5-MfQ{z>sT_nP3nTu9hLjARE0F]palf_dDxT:}RoQ=g/
expiration-hours: 3
issuer: wonsun2006
```
