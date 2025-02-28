import { cookies } from 'next/headers'
import Content from './component/content';

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
        <Content loginUser={loginUser}/>
      </div>
    </div>
  );
}
