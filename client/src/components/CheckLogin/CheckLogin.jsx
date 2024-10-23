'use client';

import { useEffect, useState } from 'react';

const payload = {
  method: 'GET',
  headers: { 'Content-Type': 'application/json' },
  credentials: 'include',
};

export const CheckLogin = () => {
  const [val, setVal] = useState(false);
  useEffect(() => {
    if (!val) {
      try {
        fetch('https://nocountry.up.railway.app/api/auth/check-login', payload)
          .then(res => {
            console.log({ res });
          })
          .catch(err => console.log({ err }));
      } catch (e) {
        console.log({ e });
      }
      setVal(true);
    }
  }, []);
  return <div className="sr-only">Check login</div>;
};
