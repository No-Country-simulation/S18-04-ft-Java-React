import Image from 'next/image';
import { useEffect, useLayoutEffect, useRef, useState } from 'react';
import CrossIcon from '/public/images/svg/CrossIcon.svg';
import Button from '../Button/Button';

export const FormStack = ({ name, label, tabIndex, icon, id }) => {
  const [tags, setTags] = useState([]);
  const [input, setInput] = useState('');
  const [isDropdownOpen, setIsDropdownOpen] = useState(false);
  const dropdownRef = useRef(null);
  const inputRef = useRef(null);

  useEffect(() => {
    if (isDropdownOpen && inputRef.current) {
      inputRef.current.focus();
    }
  }, [isDropdownOpen]);

  useLayoutEffect(() => {
    const handleClickOutside = event => {
      if (dropdownRef.current && !dropdownRef.current.contains(event.target)) {
        setIsDropdownOpen(false);
      }
    };

    document.addEventListener('mousedown', handleClickOutside);
    return () => {
      document.removeEventListener('mousedown', handleClickOutside);
    };
  }, []);

  const handleInputChange = e => {
    setInput(e.target.value);
  };

  const handleInputKeyDown = e => {
    if (e.key === 'Enter' && input) {
      e.preventDefault();
      addTag(input);
    }
  };

  const addTag = tag => {
    if (tag && !tags.includes(tag)) {
      setTags([...tags, tag]);
      setInput('');
      setIsDropdownOpen(false);
    }
  };

  const removeTag = tagToRemove => {
    setTags(tags.filter(tag => tag !== tagToRemove));
  };
  return (
    <div
      data-state={isDropdownOpen ? 'open' : 'closed'}
      aria-expanded={isDropdownOpen ? true : false}
      data-aria-hidden={isDropdownOpen ? true : false}
      className="relative flex w-full min-w-full flex-col text-base font-normal leading-4 text-white"
      id={id}
      datatest-id={id}
      ref={dropdownRef}>
      <label className="mb-4">{label}</label>
      <input
        type="hidden"
        id={`${id}-hidden`}
        aria-live="off"
        className="sr-only"
        name={name}
        value={tags.join(',')}
      />
      <div
        data-state={isDropdownOpen ? 'open' : 'closed'}
        className="no-outline ease border-gradient relative flex min-h-12 flex-wrap items-center gap-x-4 gap-y-3 bg-transparent px-3 py-2 text-base transition-all duration-300">
        {tags.map(tag => (
          <span
            key={tag}
            className="flex items-center rounded-md bg-accent-200/15 px-2 py-1 text-sm text-white">
            {tag}
            <button type="button" onClick={() => removeTag(tag)} className="no-outline ml-2">
              <Image
                src={CrossIcon}
                alt="Remove tag icon"
                width={20}
                height={20}
                className="aspect-square max-w-full"
              />
            </button>
          </span>
        ))}
        <button
          tabIndex={tabIndex}
          type="button"
          onClick={() => setIsDropdownOpen(!isDropdownOpen)}
          className="no-outline ml-auto"
          aria-label="Añadir etiqueta">
          <Image
            src={icon}
            alt="Add stack icon"
            width={20}
            height={20}
            className="aspect-square max-w-full"
          />
        </button>
      </div>
      {isDropdownOpen && (
        <div
          data-state={isDropdownOpen ? 'open' : 'closed'}
          className="absolute -bottom-36 z-20 flex w-full flex-col gap-y-3 rounded-md bg-primary-500 px-6 py-4">
          <input
            ref={inputRef}
            type="text"
            value={input}
            onChange={handleInputChange}
            onKeyDown={handleInputKeyDown}
            className="no-outline h-10 w-full rounded-md bg-primary-400 px-4 py-2 text-white placeholder:text-gray-400"
            placeholder="Añade al stack"
          />
          <Button type="button" size="full" variant="primary" onClick={() => addTag(input)}>
            Añadir
          </Button>
        </div>
      )}
    </div>
  );
};
