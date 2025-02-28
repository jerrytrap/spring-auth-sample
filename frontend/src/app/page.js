import { cookies } from 'next/headers'

export async function getLoginState() {
  const response = await fetch("http://localhost:8080/member/info", {
    method: 'GET',
    headers: { Cookie: await cookies() },
    credentials: 'include'
  });
  
  if (response.ok) {
    const data = await response.json();
    return data;
  } else {
    return null;
  }
}

export default async function Home() {
  const loginUser = await getLoginState();
  
  return (
    <div>
      <h2>메인 페이지입니다.</h2>
      <div>
        {loginUser? 
        <div>
          <h4>{loginUser.username}님 환영합니다!</h4>
          <a href="http://localhost:8080/logout">로그아웃</a> 
        </div>
        : 
        <a href="/login">로그인</a>
        }
      </div>
    </div>
  );
}
