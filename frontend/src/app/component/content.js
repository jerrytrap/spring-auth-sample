'use client'

export default function Content({ loginUser }) {
  const handleLogout = (e) => {
    e.preventDefault();

    const response = fetch('http://localhost:8080/api/auth/sign-out', {
      method: 'POST',
      credentials: 'include'
    });

    response.then((result) => {
      if (result.ok) {
        window.location.reload();
      }
    });
  };

  return (
    <div>
      {loginUser? 
      <div>
        <h4>{loginUser.username}님 환영합니다!</h4>
        <a href="#" onClick={handleLogout}>로그아웃</a>
      </div>
      : 
      <a href="/login">로그인</a>
      }
    </div>
  );
}